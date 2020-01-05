package decaf.backend.dataflow;

public interface AnalysisInfo extends Comparable<CopyOptInfo>  {
    @Override
    int compareTo(CopyOptInfo o);
}
