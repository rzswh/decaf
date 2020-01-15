package decaf.frontend.symbol;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.scope.GlobalScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.frontend.type.ClassType;
import decaf.lowlevel.tac.ClassInfo;

import java.util.ArrayList;
public final class ClassSymbol extends Symbol {

    public final Optional<ClassSymbol> parentSymbol;

    public final ClassType type;

    /**
     * Associated class scope of this class.
     */
    public final ClassScope scope;
    public ArrayList<MethodSymbol> abstractMethods;
    public final Tree.Modifiers modifiers;

    public ClassSymbol(String name, ClassType type, ClassScope scope, Pos pos, Tree.Modifiers modifiers) {
        super(name, type, pos);
        this.parentSymbol = Optional.empty();
    public ArrayList<MethodSymbol> abstractMethods;
    public final Tree.Modifiers modifiers;

    public ClassSymbol(String name, ClassType type, ClassScope scope, Pos pos, Tree.Modifiers modifiers) {
        this.scope = scope;
        this.type = type;
        this.modifiers = modifiers;
        scope.setOwner(this);
        this.modifiers = modifiers;
        scope.setOwner(this);
    }

    public ClassSymbol(String name, ClassSymbol parentSymbol, ClassType type, ClassScope scope, Pos pos, Tree.Modifiers modifiers) {
    /**
     * Set as main class, by {@link decaf.frontend.typecheck.Namer}.
     */
    public void setMainClass() {
        this.modifiers = modifiers;
     * Is it a main function?
     *
     * @return true/false
     */
    public boolean isMainClass() {
        return main;
    }

    @Override
    protected String str() {
        return (modifiers.toString().length() == 0 ? "" : modifiers + " ")
                + "class " + name + parentSymbol.map(classSymbol -> " : " + classSymbol.name).orElse("");
    }

    /**
     * Get class info, required by tac generation.
     *
     * @return class info
     * @see decaf.lowlevel.tac.ClassInfo
     */
    public ClassInfo getInfo() {
        var memberVariables = new TreeSet<String>();
        var memberMethods = new TreeSet<String>();
        var staticMethods = new TreeSet<String>();

        for (var symbol : scope) {
            if (symbol.isVarSymbol()) {
                memberVariables.add(symbol.name);
            } else if (symbol.isMethodSymbol()) {
                var methodSymbol = (MethodSymbol) symbol;
                if (methodSymbol.isStatic()) {
        return (modifiers.toString().length() == 0 ? "" : modifiers + " ")
                + "class " + name + parentSymbol.map(classSymbol -> " : " + classSymbol.name).orElse("");

        return new ClassInfo(name, parentSymbol.map(symbol -> symbol.name), memberVariables, memberMethods,
                staticMethods, isMainClass());
    }

    private boolean main;

    public boolean isAbstract() {
        return !abstractMethods.isEmpty();
    }
}

    public boolean isAbstract() {
        return !abstractMethods.isEmpty();
    }
