package decaf.backend.opt;

import decaf.backend.dataflow.CFGBuilder;
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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TAC optimization phase: optimize a TAC program.
 * <p>
 * The original decaf compiler has NO optimization, thus, we implement the transformation as identity function.
 */
public class Optimizer extends Phase<TacProg, TacProg> {
    public Optimizer(Config config) {
        super("optimizer", config);
    }

    @Override
    public TacProg transform(TacProg input) {
        return optDeadCode(input);
    }

    public TacProg optDeadCode(TacProg input) {
        var analyzer = new LivenessAnalyzer<>();
        boolean finished;
        do {
            finished = true;
            for (var f : input.funcs) {
                var builder = new CFGBuilder<>();
                List<PseudoInstr> instrs = f.getInstrSeq().stream().map(i -> (PseudoInstr) i).collect(Collectors.toList());
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
                        if (!(loc.instr instanceof TacInstr)) dead = false;
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
                            f.getInstrSeq().remove((TacInstr) loc.instr);
                            finished = false;
                        } else {
                            // update liveOut
                            loc.liveIn.removeAll(loc.instr.getWritten());
                            loc.liveIn.addAll(loc.instr.getRead());
                        }
                        liveOut = loc.liveIn;
                    }
                }
            }
        } while (!finished);
        return input;
    }

    @Override
    public void onSucceed(TacProg program) {
        if (config.target.equals(Config.Target.PA4)) {
            // First dump the tac program to file,
            var path = config.dstPath.resolve(config.getSourceBaseName() + ".tac");
            try {
                var printer = new PrintWriter(path.toFile());
                program.printTo(printer);
                printer.close();
            } catch (FileNotFoundException e) {
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
