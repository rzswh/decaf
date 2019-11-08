package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：declaration of 'abcde' here conflicts with earlier declaration at (3,2)<br>
 * PA2
 */
public class AbstractMethodNotOverridingError extends DecafError{


    private String name;

    public AbstractMethodNotOverridingError(Pos pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    protected String getErrMsg() {
        return "'" + name + "' is not abstract and does not override all abstract methods";
    }

}
