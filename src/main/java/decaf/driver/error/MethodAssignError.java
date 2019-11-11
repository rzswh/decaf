package decaf.driver.error;

import decaf.frontend.tree.Pos;

public class MethodAssignError extends DecafError {
    private String name;

    public MethodAssignError(Pos pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    protected String getErrMsg() { return "cannot assign value to class member method '" + name + "'"; }
}
