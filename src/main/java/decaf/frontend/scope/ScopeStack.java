package decaf.frontend.scope;

import decaf.frontend.symbol.ClassSymbol;
import decaf.frontend.symbol.LambdaSymbol;
import decaf.frontend.symbol.MethodSymbol;
import decaf.frontend.symbol.Symbol;
import decaf.frontend.tree.Pos;
import org.apache.commons.lang3.tuple.Pair;

import javax.swing.text.html.Option;
 * A symbol table, which is organized as a stack of scopes, maintained by {@link decaf.frontend.typecheck.Namer}.
 * <p>
 * A typical full scope stack looks like the following:
 * <pre>
 *     LocalScope   --- stack top (current scope)
 *     ...          --- many nested local scopes
 *     LocalScope
 *     FormalScope
 *     ClassScope
 *     ...          --- many parent class scopes
 *     ClassScope
 *     GlobalScope  --- stack bottom
 * </pre>
 * Make sure the global scope is always at the bottom, and NO class scope appears in neither formal nor local scope.
 *
 * @see Scope
 */
public class ScopeStack {

    /**
     * The global scope.
     */
    public final GlobalScope global;

    public ScopeStack(GlobalScope global) {
        this.global = global;
    }

    /**
     * The current scope, at the stack top.
     *
     * @return current scope
     */
    public Scope currentScope() {
        if (scopeStack.isEmpty()) return global;
        return scopeStack.peek();
    }

    /**
     * The innermost (top most on stack) class we now locate in.
     *
     * @return class symbol
     */
    public ClassSymbol currentClass() {
        Objects.requireNonNull(currClass);
        return currClass;
    }

    /**
     * The method we now locate in.
     *
     * @return method symbol
     */
    public MethodSymbol currentMethod() {
        Objects.requireNonNull(currMethod);
        return currMethod;
    }


    public Optional<LambdaSymbol> currentLambda() {
        return lambdaStack.empty() ? Optional.empty() : Optional.of(lambdaStack.peek());
    }

    /**
     * Open a scope.

    public Optional<LambdaSymbol> currentLambda() {
        return lambdaStack.empty() ? Optional.empty() : Optional.of(lambdaStack.peek());
    }

        assert !scope.isGlobalScope();
        if (scope.isClassScope()) {
            assert !currentScope().isFormalOrLocalScope();
            var classScope = (ClassScope) scope;
            classScope.parentScope.ifPresent(this::open);
            currClass = classScope.getOwner();
        } else if (scope.isFormalScope()) {
            var formalScope = (FormalScope) scope;
            currMethod = formalScope.getOwner();
        } else if (scope.isLambdaScope()) {
            lambdaStack.push(((LambdaScope) scope).getOwner());
        }
        scopeStack.push(scope);
    }

    /**
     * Close the current scope.
     * <p>
     * If the current scope is a class scope, then we must close this class and all super classes. Since the global
        } else if (scope.isLambdaScope()) {
            lambdaStack.push(((LambdaScope) scope).getOwner());
        Scope scope = scopeStack.pop();
        if (scope.isLambdaScope())
            lambdaStack.pop();
        if (scope.isClassScope()) {
            while (!scopeStack.isEmpty()) {
                scopeStack.pop();
            }
        }
    }

    /**
     * Lookup a symbol by name. By saying "lookup", the user expects that the symbol is found.
     * In this way, we will always search in all possible scopes and returns the innermost result.
     *
        if (scope.isLambdaScope())
            lambdaStack.pop();
    }

    /**
     * Same with {@link #lookup} but we restrict the symbol's position to be before the given {@code pos}.
     * EDIT: the second part of the condition: referring to a defining symbol, which is accessed inside a different
     * scope (assigning scope pk accessing scope)
     *
     * @param key symbol's name
     * @param pos position
     * @return innermost found symbol before {@code pos} (if any)
     */
    public Optional<Symbol> lookupBefore(String key, Pos pos) {
        return findWhile(key, whatever -> true,
                s -> !(s.domain().isLocalScope() && s.pos.compareTo(pos) >= 0)
                        && !(!definingSymbol.empty() && definingSymbol.peek().getRight() != currentScope()
                        && definingSymbol.peek().getLeft() == s));
    }

    /**
     * Find if a symbol is conflicting with some already defined symbol. Rules:
     * EDIT: the second part of the condition: referring to a defining symbol, which is accessed inside a different
     * scope (assigning scope pk accessing scope)
     * <p>
     * NO override checking is issued here -- the type checker is in charge of this!
     *
     * @param key symbol's name
     * @return innermost conflicting symbol (if any)
     */
        return findWhile(key, whatever -> true,
                s -> !(s.domain().isLocalScope() && s.pos.compareTo(pos) >= 0)
                        && !(!definingSymbol.empty() && definingSymbol.peek().getRight() != currentScope()
                        && definingSymbol.peek().getLeft() == s));
     *
     * @param key class's name
     * @return true/false
     */
    public boolean containsClass(String key) {
        return global.containsKey(key);
    }

    /**
     * Lookup a class in the global scope.
     *
     * @param key class's name
     * @return class symbol (if found)
     */
    public Optional<ClassSymbol> lookupClass(String key) {
        return Optional.ofNullable(global.getClass(key));
    }

    /**
     * Get a class from global scope.
     *
     * @param key class's name
     * @return class symbol (if found) or null (if not found)
     */
    public ClassSymbol getClass(String key) {
        return global.getClass(key);
    }

    /**
     * Declare a symbol in the current scope.
     *
     * @param symbol symbol
     * @see Scope#declare
     */
    public void declare(Symbol symbol) {
        currentScope().declare(symbol);
    }

    /**
     * Record currently defining symbol.
     * It is especially useful when defining lambda variables, where
     * lambda expressions are not allowed to access the symbol it is being assigned to.
     * Invoke this method when initialization or assignment.
     *
     * @param symbol the symbol being defined
     */
    public void setDefining(Symbol symbol) {
        currentlyDefining = symbol;
    }
    public void defined() {
        definingSymbol.pop();
    }
    public void defining() {
        assert currentlyDefining != null;
        definingSymbol.push(Pair.of(currentlyDefining, currentScope()));
    }
    public boolean isBeingDefined(Symbol symbol) {
        for (var defSym : definingSymbol) {
            if (symbol == defSym.getLeft() && currentScope() != defSym.getRight())
                return true;
        }
    /**
     * Record currently defining symbol.
     * It is especially useful when defining lambda variables, where
     * lambda expressions are not allowed to access the symbol it is being assigned to.
     * Invoke this method when initialization or assignment.
     *
     * @param symbol the symbol being defined
     */
    public void setDefining(Symbol symbol) {
        currentlyDefining = symbol;
    }
    public void defined() {
        definingSymbol.pop();
    }
    public void defining() {
        assert currentlyDefining != null;
        definingSymbol.push(Pair.of(currentlyDefining, currentScope()));
    }
    public boolean isBeingDefined(Symbol symbol) {
        for (var defSym : definingSymbol) {
            if (symbol == defSym.getLeft() && currentScope() != defSym.getRight())
                return true;
        }
        return false;
    }

    private Stack<Scope> scopeStack = new Stack<>();
    private ClassSymbol currClass;
    private MethodSymbol currMethod;
    private Stack<LambdaSymbol> lambdaStack = new Stack<>();
    private Stack<Pair<Symbol, Scope>> definingSymbol = new Stack<>();
    private Symbol currentlyDefining = null;
