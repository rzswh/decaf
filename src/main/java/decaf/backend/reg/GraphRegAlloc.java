package decaf.backend.reg;

import decaf.backend.asm.AsmEmitter;
import decaf.backend.asm.HoleInstr;
import decaf.backend.asm.SubroutineEmitter;
import decaf.backend.asm.SubroutineInfo;
import decaf.backend.dataflow.BasicBlock;
import decaf.backend.dataflow.CFG;
import decaf.backend.dataflow.Loc;
import decaf.lowlevel.instr.PseudoInstr;
import decaf.lowlevel.instr.Reg;
import decaf.lowlevel.instr.Temp;

import java.util.*;

public class GraphRegAlloc extends RegAlloc {


    public GraphRegAlloc(AsmEmitter emitter) {
        super(emitter);
        for (var reg : emitter.allocatableRegs) {
            reg.used = false;
        }
    }

    @Override
    public void accept(CFG<PseudoInstr> graph, SubroutineInfo info) {
        var intGraph = buildInterfereGraph(graph);
        var coloring = intGraph.colorWith(emitter.allocatableRegs.length);
        var subEmitter = emitter.emitSubroutine(info);
        var callerNeedSave = new ArrayList<Reg>();
        for (int i = 0; i < info.numArg; i++) {
            var argi = new Temp(i);
            var ind = Optional.ofNullable(coloring.get(argi.index));
            if (ind.isEmpty()) continue;
            var reg = emitter.allocatableRegs[ind.get()];
            reg.temp = argi;
            subEmitter.emitLoadFromStack(reg, argi);
        }
        for (var bb : graph) {
            bb.label.ifPresent(subEmitter::emitLabel);
            for (var loc : bb) {
                if (loc.instr instanceof HoleInstr) {
                    if (loc.instr.equals(HoleInstr.CallerSave)) {
                        for (var x : emitter.callerSaveRegs) {
                            if (x.temp == null || loc.liveOut.stream().noneMatch(l -> l.index == x.temp.index))
                                continue;
                            var ind = Optional.ofNullable(coloring.get(x.temp.index));
                            if (ind.isEmpty()) continue;
                            var reg = emitter.allocatableRegs[ind.get()];
                            // maybe its temp had been binded to another, but not updated here?
                            if (reg != x) continue;
                            callerNeedSave.add(reg);
                            subEmitter.emitStoreToStack(reg);
                        }
                    } else if (loc.instr.equals(HoleInstr.CallerRestore)) {
                        for (var reg : callerNeedSave) {
                            subEmitter.emitLoadFromStack(reg, reg.temp);
                        }
                        callerNeedSave.clear();
                    }
                } else {
                    allocForLoc(loc, subEmitter, coloring);
                }
            }
        }
        used.clear();
        subEmitter.emitEnd();
    }

    private void allocForLoc(Loc<PseudoInstr> loc, SubroutineEmitter subEmitter, TreeMap<Integer, Integer> coloring) {
        var instr = loc.instr;
        var srcRegs = new Reg[instr.srcs.length];
        var dstRegs = new Reg[instr.dsts.length];

        for (var i = 0; i < instr.srcs.length; i++) {
            var temp = instr.srcs[i];
            if (temp instanceof Reg) {
                srcRegs[i] = (Reg) temp;
            } else {
                var ind = Optional.ofNullable(coloring.get(temp.index));
                assert ind.isPresent();
                srcRegs[i] = emitter.allocatableRegs[ind.get()];
                srcRegs[i].temp = temp;
//                if (!used.contains(temp)) {
//                    used.add(temp);
//                    subEmitter.emitLoadFromStack(srcRegs[i], temp);
//                }
            }
        }

        for (var i = 0; i < instr.dsts.length; i++) {
            var temp = instr.dsts[i];
            if (temp instanceof Reg) {
                dstRegs[i] = ((Reg) temp);
            } else {
                var ind = Optional.ofNullable(coloring.get(temp.index));
                assert ind.isPresent();
                dstRegs[i] = emitter.allocatableRegs[ind.get()];
                dstRegs[i].temp = temp;
//                used.add(temp);
            }
        }

        subEmitter.emitNative(instr.toNative(dstRegs, srcRegs));
    }

    /**
     * Node numbering rules:
     *  - Temp is labeled 0 ~ N-1
     *  - Reg is labeled by -Index
     */
    InterfereGraph buildInterfereGraph(CFG<PseudoInstr> graph) {
        var ret = new InterfereGraph(emitter.allocatableRegs);
        for (var block : graph) {
            for (var s : block.allSeq()) {
                for (var d : s.instr.dsts) {
                    getIndex(d.index).ifPresent(di -> {
                        ret.addNode(d.index);
                        s.liveOut.forEach(x -> getIndex(x.index).ifPresent(xi -> ret.addEdge(d.index, x.index)));
                    });
                }
                for (var r: s.instr.srcs) getIndex(r.index).ifPresent(x -> ret.addNode(r.index));
            }
            ArrayList<Integer> liveIns = new ArrayList<>();
            block.liveIn.forEach(x -> getIndex(x.index).ifPresent(y -> liveIns.add(x.index)));
            for (int i = 0; i < liveIns.size(); i++) {
                for (int j = i + 1; j < liveIns.size(); j++) {
                    ret.addEdge(liveIns.get(i), liveIns.get(j));
                }
            }
        }
        return ret;
    }

    private Optional<Integer> getIndex(int temp) {
        if (temp >= 0) return Optional.of(temp);
        int index = regToIndex(temp);
        return index == -1 ? Optional.empty() : Optional.of(index);
    }

    private int regToIndex(int reg) {
        for (int i = 0; i < emitter.allocatableRegs.length; i++) {
            if (emitter.allocatableRegs[i].index == reg)
                return i;
        }
        return -1;
    }

    private TreeSet<Temp> used = new TreeSet<>();
}
