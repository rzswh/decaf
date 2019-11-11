
package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：incompatible return types in blocked expression<br>
 * PA2
 */
public class BadReturnTypeBlockExprError extends DecafError {

    public BadReturnTypeBlockExprError(Pos pos) {
        super(pos);
    }

    @Override
    protected String getErrMsg() {
        return "incompatible return types in blocked expression";
    }
}
