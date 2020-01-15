package decaf.frontend.scope;

import decaf.frontend.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    private Scope parent;

    public LocalScope(Scope parent) {
        super(Kind.LOCAL);
        assert parent.isFormalOrLocalScope();
    private Scope parent;

    public LocalScope(Scope parent) {
        super(Kind.LOCAL);
        assert parent.isFormalOrLocalScope();
        this.parent = parent;
        if (parent.isFormalScope() ) {
            ((FormalScope) parent).setNested(this);
        } else if (parent.isLambdaScope()) {
            ((LambdaScope) parent).setNested(this);
            if (s instanceof LocalScope)
                ret = ret.or(() -> ((LocalScope) s).lookupWithin(symbol));
        return ret;
    }

    /**
     * Collect all local scopes defined inside this scope.
     *
     * @return local scopes
     */
    public Optional<Symbol> lookupWithin(Symbol symbol) {
        var ret = find(symbol.name);
        for (var s : nested)
            if (s instanceof LocalScope)
                ret = ret.or(() -> ((LocalScope) s).lookupWithin(symbol));
        return ret;
    }

    }
}
    public List<Scope> nestedLocalScopes() {
        return nested;
    }

    private List<Scope> nested = new ArrayList<>();

    /**
     * Find the smallest belonging FormalScope / ClassScope
     */
    public Scope belongingScope() {
        return parent instanceof LocalScope ? ((LocalScope) parent).belongingScope() : parent;
    }
