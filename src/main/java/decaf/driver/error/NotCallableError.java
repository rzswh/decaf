package decaf.driver.error;

import decaf.frontend.tree.Pos;

public class NotCallableError extends DecafError {

    private String type;

    public NotCallableError(String type, Pos pos) {
        super(pos);
        this.type = type;
    }

    @Override
    protected String getErrMsg() {
        return type + " is not a callable type";
        }

}
