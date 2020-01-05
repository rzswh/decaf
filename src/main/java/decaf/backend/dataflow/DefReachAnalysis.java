package decaf.backend.dataflow;

import decaf.lowlevel.instr.PseudoInstr;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public abstract class DefReachAnalysis<I extends PseudoInstr, V extends AnalysisInfo> implements Consumer<CFG<I>> {
    @Override
    public void accept(CFG<I> graph) {
        for (var block: graph.nodes) {
            computeGenAndKillFor(block);
            block.in = new TreeSet<>();
            initialize(setO2V( block.in), block.id == 0);
            block.out = new TreeSet<>();
            block.out.add(zero());
            update(block.out, block.in, block.gen, block.kill);
        }
        var changed = false;
        do {
            changed = false;
            for (var block: graph.nodes) {
                if (block.id > 0){
                    block.in = new TreeSet<>();
                    block.in.add(zero());
                    for (var next : graph.getPrev(block.id)) {
                        if (block.in == null)
                            block.in = graph.getBlock(next).out;
                        else block.in = merge(block.in, graph.getBlock(next).out);
                    }
                }
                assert block.in != null;
                if (update(block.out, block.in, block.gen, block.kill) != 0)
                    changed = true;
            }
        } while (changed);

        // analyze for each loc
        for (var block: graph.nodes) {
            var in = new TreeSet<>(block.in);
            for (var loc : block) {
                loc.in = new TreeSet<>(in);
                update(in, loc.in, setV2O(getGen(loc)), setV2O(getKill(loc)));
                loc.out = new TreeSet<>(in);
            }
        }
    }

    void computeGenAndKillFor(BasicBlock<I> block) {
        block.gen = new TreeSet<>();
        block.kill = new TreeSet<>();

        for (var loc: block) {
            var kills = getKill(loc);
            block.kill.addAll(kills);
            for (var k : kills) {
                block.gen.removeIf(x -> ((CopyOptInfo)x).data.getRight() == ((CopyOptInfo)k).data.getLeft());
            }
            var gens = getGen(loc);
            for (var k : gens) {
                block.gen.removeIf(x -> ((CopyOptInfo)x).data.getLeft() == ((CopyOptInfo)k).data.getLeft());
            }
            block.gen.addAll(gens);
        }
    }

    private Set<V> getGen(Loc<I> loc) {
        gens.putIfAbsent(loc, computeGen(loc));
        return gens.get(loc);
    }

    private Set<V> getKill(Loc<I> loc) {
        kills.putIfAbsent(loc, computeKill(loc));
        return kills.get(loc);
    }

    abstract void initialize(Set<V> set, boolean isEntry);
    abstract int update(Set<AnalysisInfo> out, Set<AnalysisInfo> in, Set<AnalysisInfo> gen, Set<AnalysisInfo> kill);
    abstract Set<AnalysisInfo> merge(Set<AnalysisInfo> in, Set<AnalysisInfo> out);
    abstract Set<V> computeGen(Loc<I> loc);
    abstract Set<V> computeKill(Loc<I> loc);
    abstract AnalysisInfo zero();

    HashMap<Loc<I>, Set<V>> gens = new HashMap<>();
    HashMap<Loc<I>, Set<V>> kills = new HashMap<>();

    private Set<AnalysisInfo> setV2O(Set<V> set) {
        return new TreeSet<>(set);
    }
    private Set<V> setO2V(Set<AnalysisInfo> set) {
        return set.stream().map(x -> (V)x).collect(Collectors.toSet());
    }
}
