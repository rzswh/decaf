package decaf.backend.dataflow;

import decaf.lowlevel.instr.Temp;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;

public class CopyOptInfo implements AnalysisInfo {
    enum Kind {ITEM, ANY};

    Kind kind;

    public Pair<Temp, Temp> data;

    CopyOptInfo(Kind kind) {
        assert kind == Kind.ANY;
        this.kind = kind;
    }

    CopyOptInfo(Pair<Temp, Temp> data) {
        this.data = data;
        kind = Kind.ITEM;
    }

    public boolean isAny() { return kind == Kind.ANY; }

    @Override
    public int compareTo(CopyOptInfo o) {
        if (kind == Kind.ANY) return o.kind == Kind.ANY ? 0 : -1;
        else return o.kind == Kind.ANY ? 1 : data.compareTo(o.data);
    }

    @Override
    public AnalysisInfo zero() {
        return new CopyOptInfo(Kind.ANY);
    }

    @Override
    public String toString() {
        return kind == Kind.ANY ? "any" : data.toString();
    }
}
