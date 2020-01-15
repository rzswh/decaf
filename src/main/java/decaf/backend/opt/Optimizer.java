package decaf.backend.opt;

import decaf.backend.dataflow.CFGBuilder;
import decaf.backend.dataflow.CopyAnalysis;
import decaf.backend.dataflow.CopyOptInfo;
import decaf.backend.dataflow.LivenessAnalyzer;
import decaf.driver.Config;
import decaf.driver.Phase;
import decaf.lowlevel.instr.PseudoInstr;
import decaf.lowlevel.instr.Temp;
import decaf.lowlevel.log.Log;
import decaf.lowlevel.tac.Simulator;
import decaf.lowlevel.tac.TacFunc;
import decaf.lowlevel.tac.TacInstr;
import decaf.lowlevel.tac.TacProg;
import decaf.printing.PrettyCFG;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.stream.Collectors;

    @Override
    public TacProg transform(TacProg input) {
        input = optCopy(input);
        return optDeadCode(input);//input; //
    }

    public TacProg optCopy(TacProg input) {
        var analyzer = new CopyAnalysis<TacInstr>();
        boolean finished;
        do {
            finished = true;
            for (var f : input.funcs) {
        input = optCopy(input);
        return optDeadCode(input);//input; //
    }

    public TacProg optCopy(TacProg input) {
        var analyzer = new CopyAnalysis<TacInstr>();
        boolean finished;
        do {
            finished = true;
            for (var f : input.funcs) {
                var builder = new CFGBuilder<TacInstr>();
                var instrs = f.getInstrSeq();
                var cfg = builder.buildFrom(instrs);
                analyzer.accept(cfg);
                for (var block : cfg.nodes) {
                    // for each sentence..
                    for (var loc : block) {
                        boolean modified = false;
                        for (int si = 0; si < loc.instr.srcs.length; ++si) {
                            var s = loc.instr.srcs[si];
                            var match = loc.in.stream().map(x->(CopyOptInfo)x)
                                    .filter(x -> x.isAny() || s == x.data.getLeft()).findFirst();
                            if (match.isPresent()) {
                                modified = true;
                                loc.instr.srcs[si] = match.get().data.getRight();
                            }
                        }
                        if (modified) {
                            // replace it
                            var ins = loc.instr;
                            if (ins instanceof TacInstr.Assign) {
                                loc.instr = new TacInstr.Assign(ins.dsts[0], ins.srcs[0]);
                            } else if (ins instanceof TacInstr.Unary) {
                                loc.instr = new TacInstr.Unary(((TacInstr.Unary) ins).op,
                                        ((TacInstr.Unary) ins).dst, ins.srcs[0]);
                            } else if (ins instanceof TacInstr.Binary) {
                                loc.instr = new TacInstr.Binary(((TacInstr.Binary) ins).op,
                                        ((TacInstr.Binary) ins).dst, ins.srcs[0], ins.srcs[1]);
                            } else if (ins instanceof TacInstr.CondBranch) {
                                loc.instr = new TacInstr.CondBranch(((TacInstr.CondBranch) ins).op, ins.srcs[0],
                                        ((TacInstr.CondBranch) ins).target);
                            } else if (ins instanceof TacInstr.Return) {
                                loc.instr = ((TacInstr.Return) ins).value.map(x -> new TacInstr.Return(ins.srcs[0]))
                                        .orElse(new TacInstr.Return());
                            } else if (ins instanceof TacInstr.Parm) {
                                loc.instr = new TacInstr.Parm(ins.srcs[0], ((TacInstr.Parm) ins).numParms);
                            } else if (ins instanceof TacInstr.IndirectCall) {
                                loc.instr = ((TacInstr.IndirectCall) ins).dst
                                        .map(x -> new TacInstr.IndirectCall(x, ins.srcs[0]))
                                        .orElse(new TacInstr.IndirectCall(ins.srcs[0]));
                            } else if (ins instanceof TacInstr.Memory) {
                                if (((TacInstr.Memory) ins).op == TacInstr.Memory.Op.LOAD) {
                                    loc.instr = new TacInstr.Memory(((TacInstr.Memory) ins).op, ins.dsts[0],
                                            ins.srcs[0], ((TacInstr.Memory) ins).offset);
                                } else {
                                    loc.instr = new TacInstr.Memory(((TacInstr.Memory) ins).op, ins.srcs[0],
                                            ins.srcs[1], ((TacInstr.Memory) ins).offset);
                                }
                            }
                            var seqList = f.getInstrSeq();
                            seqList.set(seqList.indexOf(ins), loc.instr);
                            finished = false;
                        }
                    }
                }
                Log.fine("Func %s:\n", f.entry);
                Log.ifLoggable(Level.FINE, printer -> new PrettyCFG<TacInstr>(printer).pretty(cfg));
            }
        } while (!finished);
        return input;
    }

    public TacProg optDeadCode(TacProg input) {
        var analyzer = new LivenessAnalyzer<TacInstr>();
        boolean finished;
        do {
            finished = true;
            for (var f : input.funcs) {
                var builder = new CFGBuilder<TacInstr>();
                var instrs = f.getInstrSeq();
                var cfg = builder.buildFrom(instrs);
                analyzer.accept(cfg);
                for (var block : cfg.nodes) {
                    var iter = block.backwardIterator();
                    Set<Temp> liveOut = null;
                    while (iter.hasNext()) {
                        var loc = iter.next();
                        if (liveOut == null) liveOut = loc.liveOut;
                        loc.liveOut = liveOut;
                        boolean dead = true;
                        // Side-effect instructions include: branch and jump, return, parameter, call, memory store
                        if (!loc.instr.isSequential()) dead = false;
                        if (loc.instr instanceof TacInstr.Parm || loc.instr instanceof TacInstr.DirectCall
                                || loc.instr instanceof TacInstr.IndirectCall) dead = false;
                        if (loc.instr instanceof TacInstr.Memory
                                && ((TacInstr.Memory) loc.instr).op == TacInstr.Memory.Op.STORE)
                            dead = false;
                        for (var tmp : loc.instr.dsts)
                            if (loc.liveOut.contains(tmp)) {
                                dead = false;
                                break;
                            }
                        loc.liveIn = new TreeSet<>(liveOut);
                        if (dead) {
                            block.locs.remove(loc);
                            f.getInstrSeq().remove(loc.instr);
                            finished = false;
                        } else {
                            // update liveOut
                            loc.liveIn.removeAll(loc.instr.getWritten());
                            loc.liveIn.addAll(loc.instr.getRead());
                        }
                        liveOut = loc.liveIn;
                    }
                }
                Log.ifLoggable(Level.FINE, printer -> new PrettyCFG<TacInstr>(printer).pretty(cfg));
            }
        } while (!finished);
                e.printStackTrace();
            }

            // and then execute it using our simulator.
            var simulator = new Simulator(System.in, config.output);
            int numExe = simulator.execute(program);
            // print num
            Log.info("Number of executed sentences: " + numExe);
        }
    }
}
            int numExe = simulator.execute(program);
            // print num
            Log.info("Number of executed sentences: " + numExe);
