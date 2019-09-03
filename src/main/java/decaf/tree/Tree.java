package decaf.tree;

import decaf.scope.GlobalScope;
import decaf.scope.LocalScope;
import decaf.scope.ScopeStack;
import decaf.symbol.Class;
import decaf.symbol.Function;
import decaf.symbol.Variable;
import decaf.tac.Temp;
import decaf.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Tree {
    public enum Kind {
        TOP_LEVEL, CLASS_DEF, VAR_DEF, METHOD_DEF,
        T_INT, T_BOOL, T_STRING, T_VOID, T_CLASS, T_ARRAY,
        LOCAL_VAR_DEF, BLOCK, ASSIGN, EXPR_EVAL, SKIP, IF, WHILE, FOR, BREAK, RETURN, PRINT,
        INT_LIT, BOOL_LIT, STRING_LIT, NULL_LIT, VAR_SEL, INDEX_SEL, CALL,
        THIS, UNARY_EXPR, BINARY_EXPR, READ_INT, READ_LINE, NEW_CLASS, NEW_ARRAY, CLASS_TEST, CLASS_CAST, ID
    }

    /**
     * A top-level decaf program, which consists of many class definitions.
     */
    public static class TopLevel extends TreeNode {
        // Tree elements
        public List<ClassDef> classes;
        // For type check
        public Class main;
        public GlobalScope globalScope;
        public ScopeStack table;

        public TopLevel(List<ClassDef> classes, Pos pos) {
            super(Kind.TOP_LEVEL, "TopLevel", pos);
            this.classes = classes;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> classes;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTopLevel(this);
        }
    }

    /**
     * Class definition:
     * {{{
     * class <id> (extends <parent>)? { <fields> }
     * }}}
     */
    public static class ClassDef extends TreeNode {
        // Tree elements
        public final Id id;
        public final Optional<Id> parent;
        public final List<Field> fields;
        // For type check
        public Class symbol;

        public ClassDef(Id id, Optional<Id> parent, List<Field> fields, Pos pos) {
            super(Kind.CLASS_DEF, "ClassDef", pos);
            this.id = id;
            this.parent = parent;
            this.fields = fields;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> id;
                case 1 -> parent;
                case 2 -> fields;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 3;
        }

        @Override
        public void accept(Visitor v) {
            v.visitClassDef(this);
        }
    }

    /**
     * Field/Member of a class.
     */
    public static abstract class Field extends TreeNode {
        public Field(Kind kind, String displayName, Pos pos) {
            super(kind, displayName, pos);
        }
    }

    /**
     * Member variable declaration:
     * {{{
     * <typ> <id>;
     * }}}
     * Initialization is not supported.
     */
    public static class VarDef extends Field {
        // Tree elements
        public TypeLit typeLit;
        public Id id;
        // For type check
        public Variable symbol;

        public VarDef(TypeLit typeLit, Id id, Pos pos) {
            super(Kind.VAR_DEF, "VarDef", pos);
            this.typeLit = typeLit;
            this.id = id;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> typeLit;
                case 1 -> id;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitVarDef(this);
        }
    }

    /**
     * Member method definition:
     * {{{
     * [static] <returnType> <id> (<typ1> <id1>, <typ2> <id2>, ...) { <body> }
     * }}}
     * Decaf has static methods but _no_ static variables, strange!
     */
    public static class MethodDef extends Field {
        // Tree elements
        public boolean isStatic; // TODO modifier
        public Id id;
        public TypeLit returnType;
        public List<LocalVarDef> params;
        public Block body;
        // For type check
        public Function symbol;

        public MethodDef(boolean isStatic, Id id, TypeLit returnType, List<LocalVarDef> params, Block body, Pos pos) {
            super(Kind.METHOD_DEF, "MethodDef", pos);
            this.isStatic = isStatic;
            this.id = id;
            this.returnType = returnType;
            this.params = params;
            this.body = body;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> isStatic;
                case 1 -> id;
                case 2 -> returnType;
                case 3 -> params;
                case 4 -> body;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 5;
        }

        public void accept(Visitor v) {
            v.visitMethodDef(this);
        }
    }

    /**
     * Type. Decaf only supports
     * - basic types (integer, boolean, string, void),
     * - class types (using class identifiers), and
     * - array types (whose element could be any type, but homogeneous).
     */
    public static abstract class TypeLit extends TreeNode {
        public Type type;

        public TypeLit(Kind kind, String displayName, Pos pos) {
            super(kind, displayName, pos);
        }
    }

    /**
     * 32 bit integer type: {{{ int }}}
     */
    public static class TInt extends TypeLit {
        public TInt(Pos pos) {
            super(Kind.T_INT, "TInt", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTInt(this);
        }
    }

    /**
     * Boolean type: {{{ bool }}}
     */
    public static class TBool extends TypeLit {
        public TBool(Pos pos) {
            super(Kind.T_BOOL, "TBool", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTBool(this);
        }
    }

    /**
     * String type: {{{ string }}}
     */
    public static class TString extends TypeLit {
        public TString(Pos pos) {
            super(Kind.T_STRING, "TString", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTString(this);
        }
    }

    /**
     * Void type: {{{ void }}}
     * For method return type _only_.
     */
    public static class TVoid extends TypeLit {
        public TVoid(Pos pos) {
            super(Kind.T_VOID, "TVoid", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTVoid(this);
        }
    }

    /**
     * Class type:
     * {{{
     * class <id>
     * }}}
     */
    public static class TClass extends TypeLit {
        // Tree element
        public Id id;

        public TClass(Id id, Pos pos) {
            super(Kind.T_CLASS, "TClass", pos);
            this.id = id;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> id;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTClass(this);
        }
    }

    /**
     * Array type:
     * {{{
     * <elemType>[]
     * }}}
     */
    public static class TArray extends TypeLit {
        // Tree element
        public TypeLit elemType;

        public TArray(TypeLit elemType, Pos pos) {
            super(Kind.T_ARRAY, "TArray", pos);
            this.elemType = elemType;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> elemType;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitTArray(this);
        }
    }


    /**
     * Statement.
     */
    public static abstract class Stmt extends TreeNode {
        public Stmt(Kind kind, String displayName, Pos pos) {
            super(kind, displayName, pos);
        }

        public boolean isBlock() {
            return false;
        }
    }

    /**
     * Local variable declaration:
     * {{{
     * <typeLit> <id>;
     * }}}
     * Initialization is not supported.
     */
    public static class LocalVarDef extends Stmt {
        // Tree elements
        public TypeLit typeLit;
        public Id id;
        // For type check
        public Variable symbol;

        public LocalVarDef(TypeLit typeLit, Id id, Pos pos) {
            super(Kind.LOCAL_VAR_DEF, "LocalVarDef", pos);
            this.typeLit = typeLit;
            this.id = id;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> typeLit;
                case 1 -> id;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitLocalVarDef(this);
        }
    }

    /**
     * Statement block:
     * {{{
     * { <stmt1> <stmt2> ... }
     * }}}
     */
    public static class Block extends Stmt {
        // Tree element
        public List<Stmt> block;
        // For type check
        public LocalScope associatedScope;

        public Block(List<Stmt> block, Pos pos) {
            super(Kind.BLOCK, "Block", pos);
            this.block = block;
        }

        @Override
        public boolean isBlock() {
            return true;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> block;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitBlock(this);
        }
    }

    /**
     * Assignment:
     * {{{
     * <lhs> = <rhs>;
     * }}}
     */
    public static class Assign extends Stmt {
        // Tree elements
        public LValue lhs;
        public Expr rhs;

        public Assign(LValue lhs, Expr rhs, Pos pos) {
            super(Kind.ASSIGN, "Assign", pos);
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> lhs;
                case 1 -> rhs;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitAssign(this);
        }
    }

    /**
     * Expression evaluation, typically a method call.
     */
    public static class ExprEval extends Stmt {
        // Tree element
        public Expr expr;

        public ExprEval(Expr expr, Pos pos) {
            super(Kind.EXPR_EVAL, "ExprEval", pos);
            this.expr = expr;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> expr;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitExprEval(this);
        }
    }

    /**
     * Empty statement, do nothing.
     */
    public static class Skip extends Stmt {

        public Skip(Pos pos) {
            super(Kind.SKIP, "Skip", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitSkip(this);
        }
    }

    /**
     * To ease the analysis of statements that naturally opens a local scope, like loop bodies and condition branches,
     * we represent them each as a Block in the abstract syntax tree level. However, it could be a single statement,
     * like a single return:
     * {{{
     * if (true) return 1;
     * }}}
     * which obeys in the grammar. In this case, we simply wrap it as a block:
     * {{{
     * if (true) { return 1; }
     * }}}
     *
     * @param stmt a statement
     * @return the wrapped block
     */
    private static Block blocked(Stmt stmt) {
        if (stmt.isBlock()) return (Block) stmt;
        var ss = new ArrayList<Stmt>();
        ss.add(stmt);
        return new Block(ss, stmt.pos);
    }

    /**
     * If statement:
     * {{{
     * if (<cond>) <trueBranch> [else <falseBranch>]
     * }}}
     */
    public static class If extends Stmt {
        // Tree elements
        public Expr cond;
        public Block trueBranch;
        public Optional<Block> falseBranch;

        public If(Expr cond, Stmt trueBranch, Optional<Stmt> falseBranch, Pos pos) {
            super(Kind.IF, "If", pos);
            this.cond = cond;
            this.trueBranch = blocked(trueBranch);
            this.falseBranch = falseBranch.map(Tree::blocked);
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> cond;
                case 1 -> trueBranch;
                case 2 -> falseBranch;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 3;
        }

        @Override
        public void accept(Visitor v) {
            v.visitIf(this);
        }
    }


    /**
     * While statement:
     * {{{
     * while (<cond>) <body>
     * }}}
     */
    public static class While extends Stmt {
        // Tree elements
        public Expr cond;
        public Block body;

        public While(Expr cond, Stmt body, Pos pos) {
            super(Kind.WHILE, "While", pos);
            this.cond = cond;
            this.body = blocked(body);
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> cond;
                case 1 -> body;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitWhile(this);
        }
    }

    /**
     * For statement:
     * {{{
     * for (<init>; <cond>; <update>) <body>
     * }}}
     */
    public static class For extends Stmt {
        // Tree elements
        public Stmt init;
        public Expr cond;
        public Stmt update;
        public Block body;

        public For(Stmt init, Expr cond, Stmt update, Stmt body, Pos pos) {
            super(Kind.FOR, "For", pos);
            this.init = init;
            this.cond = cond;
            this.update = update;
            this.body = blocked(body);
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> init;
                case 1 -> cond;
                case 2 -> update;
                case 3 -> body;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 4;
        }

        @Override
        public void accept(Visitor v) {
            v.visitFor(this);
        }
    }

    /**
     * Break statement:
     * {{{
     * break;
     * }}}
     * <p>
     * Jump out of the _innermost_ loop.
     */
    public static class Break extends Stmt {

        public Break(Pos pos) {
            super(Kind.BREAK, "Break", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitBreak(this);
        }
    }


    /**
     * Method return statement:
     * {{{
     * return [<expr>];
     * }}}
     */
    public static class Return extends Stmt {
        // Tree elements
        public Optional<Expr> expr;

        public Return(Optional<Expr> expr, Pos pos) {
            super(Kind.RETURN, "Return", pos);
            this.expr = expr;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> expr;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitReturn(this);
        }
    }

    /**
     * A return statement.
     */
    public static class Print extends Stmt {
        // Tree elements
        public List<Expr> exprs;

        public Print(List<Expr> exprs, Pos pos) {
            super(Kind.PRINT, "Print", pos);
            this.exprs = exprs;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> exprs;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitPrint(this);
        }
    }

    /**
     * Expression.
     */
    public abstract static class Expr extends TreeNode {

        public Type type;
        public Temp val;
        public boolean isClass;
        public boolean usedForRef;

        public Expr(Kind kind, String displayName, Pos pos) {
            super(kind, displayName, pos);
        }
    }

    /**
     * Integer literal.
     */
    public static class IntLit extends Expr {
        // Tree element
        public int value;

        public IntLit(int value, Pos pos) {
            super(Kind.INT_LIT, "IntLit", pos);
            this.value = value;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> value;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitIntLit(this);
        }
    }

    /**
     * Boolean literal.
     */
    public static class BoolLit extends Expr {
        // Tree element
        public boolean value;

        public BoolLit(boolean value, Pos pos) {
            super(Kind.BOOL_LIT, "BoolLit", pos);
            this.value = value;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> value;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitBoolLit(this);
        }
    }

    /**
     * String literal.
     */
    public static class StringLit extends Expr {
        // Tree element
        public String value;

        public StringLit(String value, Pos pos) {
            super(Kind.STRING_LIT, "StringLit", pos);
            this.value = value;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> value;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitStringLit(this);
        }
    }

    /**
     * Null literal:  {{{ null }}}
     */
    public static class NullLit extends Expr {
        // Tree element
        public final Object value = null;

        public NullLit(Pos pos) {
            super(Kind.NULL_LIT, "NullLit", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visitNullLit(this);
        }
    }

    public static abstract class LValue extends Expr {

        public enum LVKind {
            LOCAL_VAR, PARAM_VAR, MEMBER_VAR, ARRAY_ELEMENT
        }

        public LVKind lvKind;

        public LValue(Kind kind, String displayName, Pos pos) {
            super(kind, displayName, pos);
        }
    }

    /**
     * Field selection, or simply a local variable:
     * {{{
     * [<receiver>.]<field>
     * }}}
     */
    public static class VarSel extends LValue {
        // Tree element
        public Optional<Expr> receiver;
        public Id variable;
        // For type check
        public Variable symbol;
        public boolean isDefined;

        public VarSel(Optional<Expr> receiver, Id variable, Pos pos) {
            super(Kind.VAR_SEL, "VarSel", pos);
            this.receiver = receiver;
            this.variable = variable;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> receiver;
                case 1 -> variable;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitVarSel(this);
        }
    }


    /**
     * Array element selection by index:
     * {{{
     * <array>[<index>]
     * }}}
     */
    public static class IndexSel extends LValue {

        public Expr array;
        public Expr index;

        public IndexSel(Expr array, Expr index, Pos pos) {
            super(Kind.INDEX_SEL, "IndexSel", pos);
            this.array = array;
            this.index = index;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> array;
                case 1 -> index;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitIndexSel(this);
        }
    }

    /**
     * This expression:
     * {{{
     * this
     * }}}
     * <p>
     * Refers to the instance of the current class.
     */
    public static class This extends Expr {

        public This(Pos pos) {
            super(Kind.THIS, "This", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visitThis(this);
        }
    }

    public enum UnaryOp {
        NEG, NOT
    }

    /**
     * 获得操作符的字符串表示
     *
     * @param op 操作符的符号码
     * @return 该操作符的字符串形式
     */
    public static String opStr(UnaryOp op) {
        return switch (op) {
            case NEG -> "-";
            case NOT -> "!";
        };
    }

    /**
     * Unary expression.
     */
    public static class Unary extends Expr {

        public UnaryOp op;
        public Expr operand;

        public Unary(UnaryOp op, Expr operand, Pos pos) {
            super(Kind.UNARY_EXPR, "Unary", pos);
            this.op = op;
            this.operand = operand;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> op;
                case 1 -> operand;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitUnary(this);
        }
    }

    public enum BinaryOp {
        ADD, SUB, MUL, DIV, MOD, EQ, NE, GE, GT, LE, LT, AND, OR
    }

    // TODO: rewrite using case expression
    public static String opStr(BinaryOp opCode) {
        switch (opCode) {
            case AND:
                return "&&";
            case EQ:
                return "==";
            case GE:
                return ">=";
            case LE:
                return "<=";
            case NE:
                return "!=";
            case OR:
                return "||";
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MUL:
                return "*";
            case DIV:
                return "/";
            case MOD:
                return "%";
            case GT:
                return ">";
            case LT:
                return "<";
            default:
                return "<unknown>";
        }
    }

    /**
     * Binary expression.
     */
    public static class Binary extends Expr {

        public BinaryOp op;
        public Expr lhs;
        public Expr rhs;

        public Binary(BinaryOp op, Expr lhs, Expr rhs, Pos pos) {
            super(Kind.BINARY_EXPR, "Binary", pos);
            this.op = op;
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> op;
                case 1 -> lhs;
                case 2 -> rhs;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 3;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visitBinary(this);
        }
    }

    /**
     * IO expression for reading an integer from stdin:
     * {{{
     * ReadInteger()
     * }}}
     */
    public static class ReadInt extends Expr {

        public ReadInt(Pos pos) {
            super(Kind.READ_INT, "ReadInt", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visitReadInt(this);
        }
    }

    /**
     * IO expression for reading a line from stdin:
     * {{{
     * ReadLine()
     * }}}
     */
    public static class ReadLine extends Expr {

        public ReadLine(Pos pos) {
            super(Kind.READ_LINE, "ReadLine", pos);
        }

        @Override
        public Object treeElementAt(int index) {
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public int treeArity() {
            return 0;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visitReadLine(this);
        }
    }


    /**
     * New expression for creating an instance:
     * {{{
     * new <id>()
     * }}}
     */
    public static class NewClass extends Expr {
        // Tree elements
        public Id clazz;
        // For type check
        public Class symbol;

        public NewClass(Id clazz, Pos pos) {
            super(Kind.NEW_CLASS, "NewClass", pos);
            this.clazz = clazz;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> clazz;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitNewClass(this);
        }
    }

    /**
     * New expression for creating an array:
     * {{{
     * new <elemType>[<length>]
     * }}}
     */
    public static class NewArray extends Expr {
        // Tree elements
        public TypeLit elemType;
        public Expr length;

        public NewArray(TypeLit elemType, Expr length, Pos pos) {
            super(Kind.NEW_ARRAY, "NewArray", pos);
            this.elemType = elemType;
            this.length = length;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> elemType;
                case 1 -> length;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitNewArray(this);
        }
    }

    /**
     * Instance-of-expression:
     * {{{
     * instanceof(<obj>, <is>)
     * }}}
     * Check if the given object `obj` is an instance of class `is`.
     */
    public static class ClassTest extends Expr {
        // Tree elements
        public Expr obj;
        public Id is;
        // For type check
        public Class symbol;

        public ClassTest(Expr obj, Id is, Pos pos) {
            super(Kind.CLASS_TEST, "ClassTest", pos);
            this.obj = obj;
            this.is = is;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> obj;
                case 1 -> is;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitClassTest(this);
        }
    }

    /**
     * Class type cast expression:
     * {{{
     * (class <to>)obj
     * }}}
     * Cast the given object `obj` into class type `to`.
     */
    public static class ClassCast extends Expr {
        // Tree elements
        public Expr obj;
        public Id to;
        // For type check
        public Class symbol;

        public ClassCast(Expr obj, Id to, Pos pos) {
            super(Kind.CLASS_CAST, "ClassCast", pos);
            this.obj = obj;
            this.to = to;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> obj;
                case 1 -> to;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 2;
        }

        @Override
        public void accept(Visitor v) {
            v.visitClassCast(this);
        }
    }


    /**
     * Call expression:
     * {{{
     * [<receiver>.]<id>(<arg1>, <arg2>, ...)
     * }}}
     */
    public static class Call extends Expr {
        // Tree elements
        public Optional<Expr> receiver;
        public Id method;
        public List<Expr> args;
        // For type check
        public Function symbol;
        public boolean isArrayLength;

        public Call(Optional<Expr> receiver, Id method, List<Expr> args, Pos pos) {
            super(Kind.CALL, "Call", pos);
            this.receiver = receiver;
            this.method = method;
            this.args = args;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> receiver;
                case 1 -> method;
                case 2 -> args;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 3;
        }

        @Override
        public void accept(Visitor v) {
            v.visitCall(this);
        }
    }

    /**
     * An identifier.
     */
    public static class Id extends TreeNode {
        public final String name;

        public Id(String name, Pos pos) {
            super(Kind.ID, "Id", pos);
            this.name = name;
        }

        @Override
        public Object treeElementAt(int index) {
            return switch (index) {
                case 0 -> name;
                default -> throw new IndexOutOfBoundsException(index);
            };
        }

        @Override
        public int treeArity() {
            return 1;
        }

        @Override
        public void accept(Visitor v) {
            v.visitId(this);
        }


        @Override
        public String toString() {
            return name;
        }
    }
}