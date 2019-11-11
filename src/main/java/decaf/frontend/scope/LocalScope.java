package decaf.frontend.scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Local scope: stores locally-defined variables.
 */
public class LocalScope extends Scope {

    private Scope parent;

    public LocalScope(Scope parent) {
        super(Kind.LOCAL);
        assert parent.isFormalOrLocalScope();
        this.parent = parent;
        if (parent.isFormalScope() ) {
            ((FormalScope) parent).setNested(this);
        } else if (parent.isLambdaScope()) {
            ((LambdaScope) parent).setNested(this);
        } else {
            ((LocalScope) parent).nested.add(this);
        }
    }

    @Override
    public boolean isLocalScope() {
        return true;
    }

    /**
     * Collect all local scopes defined inside this scope.
     *
     * @return local scopes
     */
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
}
