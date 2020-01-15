package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：function 'gotoMars' expects 1 argument(s) but 3 given<br>
 * PA2
 */
public class BadArgCountError extends DecafError {

    private String method;

    private int expect;

    private int count;

    private boolean isLambda;

    public BadArgCountError(Pos pos, String method, int expect,
                            int count, boolean isLambda) {
    }

    @Override
    protected String getErrMsg() {
        this.isLambda = isLambda;
        var prefix = isLambda ? "lambda expression" : "function '" + method + "'";
        return prefix + " expects " + expect + " argument(s) but " + count + " given";
