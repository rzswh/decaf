package decaf.frontend.symbol;

import decaf.frontend.scope.LambdaScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.type.FunType;

import java.util.ArrayList;
import java.util.List;

public class LambdaSymbol extends Symbol {

    public final FunType type;

    /**
     * Associated formal scope of the method parameters.
     */
    public final LambdaScope scope;

    public final MethodSymbol owner;

    public boolean finished = false;

    public List<VarSymbol> captured = new ArrayList<>();

    public LambdaSymbol(FunType type, LambdaScope scope, Pos pos,
                        MethodSymbol owner) {
        super("lambda@" + pos, type, pos);
        this.type = type;
        this.scope = scope;
        this.owner = owner;
        scope.setOwner(this);
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
