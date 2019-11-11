package decaf.driver.error;

import decaf.frontend.tree.Pos;

public class FunctionTypeArgsVoidError extends DecafError {

    public FunctionTypeArgsVoidError(Pos pos) {
        super(pos);
    }

    @Override
    protected String getErrMsg() {
        return "arguments in function type must be non-void known type";
    }
}
