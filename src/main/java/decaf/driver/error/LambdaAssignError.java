package decaf.driver.error;

import decaf.frontend.tree.Pos;

public class LambdaAssignError extends DecafError {
    public LambdaAssignError(Pos pos) { super(pos); }

    @Override
    protected String getErrMsg() { return "cannot assign value to captured variables in lambda expression"; }
}
