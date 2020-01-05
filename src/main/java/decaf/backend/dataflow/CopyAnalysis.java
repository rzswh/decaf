package decaf.backend.dataflow;

import decaf.frontend.tree.Tree;
import decaf.lowlevel.instr.PseudoInstr;
import decaf.lowlevel.instr.Temp;
import decaf.lowlevel.tac.TacInstr;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;
import java.util.TreeSet;

public class CopyAnalysis<I extends PseudoInstr> extends DefReachAnalysis<I, CopyOptInfo> {

    @Override
    void initialize(Set<CopyOptInfo> set, boolean isEntry) {
        if (!isEntry) set.add(any());
    }

    @Override
    Set<CopyOptInfo> computeGen(Loc<I> loc) {
        return loc.instr instanceof TacInstr.Assign ? new TreeSet<>(Set.of(new CopyOptInfo(
                Pair.of(((TacInstr.Assign) loc.instr).dst, ((TacInstr.Assign) loc.instr).src)
        ))): Set.of();
    }

    @Override
    Set<CopyOptInfo> computeKill(Loc<I> loc) {
        var ret = new TreeSet<CopyOptInfo>();
        for (var d : loc.instr.dsts)
            ret.add(new CopyOptInfo(Pair.of(d, d)));
        return ret;
    }

    @Override
    int update(Set<AnalysisInfo> out, Set<AnalysisInfo> in, Set<AnalysisInfo> gen, Set<AnalysisInfo> kill) {
        if (in.size() == 1 && ((CopyOptInfo)(in.iterator().next())).isAny()) {
            out.clear();
            out.add(any());
            return 1;
        }
        var old = new TreeSet<>(out);
        int ret = 0;
        out.clear();
        out.addAll(in);
        out.removeIf(x-> {
            for (var p: kill) {
                if (((CopyOptInfo)x).data.getRight() == ((CopyOptInfo)p).data.getLeft())
                    return true;
            }
            for (var p : gen) {
                if (((CopyOptInfo)x).data.getLeft() == ((CopyOptInfo)p).data.getLeft())
                    return true;
            }
            return false;
        });
        out.addAll(gen);
        return old.retainAll(out) ? 1 : 0;
    }

    @Override
    void merge(Set<AnalysisInfo> in, Set<AnalysisInfo> out) {
        if (in.size() == 1 && ((CopyOptInfo)(in.iterator().next())).isAny())
            return;
        if (out.size() == 1 && ((CopyOptInfo)(out.iterator().next())).isAny()) {
            out.clear();
            out.addAll(in);
        } else {
            out.retainAll(in);
        }
    }

    private CopyOptInfo any() {
        return new CopyOptInfo(CopyOptInfo.Kind.ANY);
    }
}
