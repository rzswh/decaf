package decaf.frontend.symbol;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.scope.FormalScope;
import decaf.frontend.scope.LambdaScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.frontend.type.FunType;

public class LambdaSymbol extends Symbol {

    public final FunType type;

    /**
     * Associated formal scope of the method parameters.
     */
    public final LambdaScope scope;

    public final MethodSymbol owner;

    public boolean finished = false;

    public LambdaSymbol(FunType type, LambdaScope scope, Pos pos,
                        MethodSymbol owner) {
        super("lambda@" + pos, type, pos);
        this.type = type;
        this.scope = scope;
        this.owner = owner;
        scope.setOwner(this);
    }

    @Override
    public ClassScope domain() {
        return (ClassScope) definedIn;
    }

    @Override
    public boolean isMethodSymbol() {
        return true;
    }

    @Override
    protected String str() {
        return String.format("function %s : %s", name, type);
    }
}
