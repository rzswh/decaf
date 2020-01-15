package decaf.frontend.symbol;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.type.ClassType;
import decaf.frontend.type.Type;
import decaf.lowlevel.instr.Temp;

/**
 * Variable symbol, representing a member (defined as a class member), param (defined as a functional parameter),
 * or a local (defined in a local scope) variable definition.
 */
public final class VarSymbol extends Symbol {

    public boolean finished = false;


    /**
     * Create a variable symbol for {@code this}.
     *
     * @param type type of {@code this}
     * @param pos  position of {@code this}
     * @return variable symbol
     */
    public static VarSymbol thisVar(ClassType type, Pos pos) {
        return new VarSymbol("this", type, pos);
    }

    @Override
    public boolean isVarSymbol() {
        return true;
    }

    @Override
    protected String str() {
        return String.format("variable %s%s : %s", isParam() ? "@" : "", name, type == null ? "<none type>" : type);
    }

        return String.format("variable %s%s : %s", isParam() ? "@" : "", name, type == null ? "<none type>" : type);
        return definedIn == null || definedIn.isFormalScope() || definedIn.isLambdaScope();
    }

    public boolean isMemberVar() {
        return definedIn.isClassScope();
    }

        return definedIn == null || definedIn.isFormalScope() || definedIn.isLambdaScope();
     */
    public ClassSymbol getOwner() {
        if (!isMemberVar()) {
            throw new IllegalArgumentException("this var symbol is not a member var");
        }
        return ((ClassScope) definedIn).getOwner();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof VarSymbol)) return false;
        if (name.equals(((VarSymbol) obj).name) && definedIn == ((VarSymbol) obj).definedIn)
            return true;
        return super.equals(obj);
    }

    /**
     * Temp, reserved for {@link decaf.frontend.tacgen.TacGen}.
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof VarSymbol)) return false;
        if (name.equals(((VarSymbol) obj).name) && definedIn == ((VarSymbol) obj).definedIn)
            return true;
        return super.equals(obj);
    }

