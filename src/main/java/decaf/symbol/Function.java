package decaf.symbol;

import decaf.scope.ClassScope;
import decaf.scope.FormalScope;
import decaf.tac.Functy;
import decaf.tree.Pos;
import decaf.tree.Tree.Block;
import decaf.type.FuncType;
import decaf.type.Type;

public class Function extends Symbol {

	private FormalScope associatedScope;

	private Functy functy;

	private boolean statik;

	private boolean isMain;

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

	public boolean isStatik() {
		return statik;
	}

	public void setStatik(boolean statik) {
		this.statik = statik;
	}

	private int offset;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Functy getFuncty() {
		return functy;
	}

	public void setFuncty(Functy functy) {
		this.functy = functy;
	}

	public Function(boolean statik, String name, Type returnType,
			Block node, Pos pos) {
		this.name = name;
		this.pos = pos;

		type = new FuncType(returnType);
		associatedScope = new FormalScope(this, node);
		ClassScope cs = null; // FIXME
		this.statik = statik;
		if (!statik) {
			Variable _this = new Variable("this", cs.getOwner().getType(),
                    pos);
			associatedScope.declare(_this);
			appendParam(_this);
		}

	}

	public FormalScope getAssociatedScope() {
		return associatedScope;
	}

	public Type getReturnType() {
		return getType().getReturnType();
	}

	public void appendParam(Variable arg) {
		arg.setOrder(getType().numOfParams());
		getType().appendParam(arg.getType());
	}

	@Override
	public ClassScope getScope() {
		return (ClassScope) definedIn;
	}

	@Override
	public FuncType getType() {
		return (FuncType) type;
	}

	@Override
	public boolean isFunction() {
		return true;
	}

	@Override
	public String toString() {
		return pos + " -> " + (statik ? "static " : "") + "function "
				+ name + " : " + type;
	}

	@Override
	public boolean isClass() {
		return false;
	}

	@Override
	public boolean isVariable() {
		return false;
	}

}