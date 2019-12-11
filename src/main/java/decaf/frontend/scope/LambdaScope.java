package decaf.frontend.scope;

import decaf.frontend.symbol.LambdaSymbol;
import decaf.frontend.symbol.Symbol;

import java.util.Optional;

public class LambdaScope extends Scope {

    public LambdaScope(Scope scope) {
        super(Kind.LAMBDA);
        assert scope instanceof LocalScope;
        ((LocalScope) scope).nestedLocalScopes().add(this);
    }

    public LambdaSymbol getOwner() {
        return owner;
    }

    public void setOwner(LambdaSymbol owner) {
        this.owner = owner;
    }

    public Optional<Symbol> lookupWithin(Symbol symbol) {
        return find(symbol.name).or(() -> nested.lookupWithin(symbol));
    }

    @Override
    public boolean isLambdaScope() {
        return true;
    }

    /**
     * Get the local scope associated with the method body.
     *
     * @return local scope
     */
    public LocalScope nestedLocalScope() {
        return nested;
    }

    /**
     * Set the local scope.
     *
     * @param scope local scope
     */
    void setNested(LocalScope scope) {
        nested = scope;
    }

    private LambdaSymbol owner;

    private LocalScope nested;
}
