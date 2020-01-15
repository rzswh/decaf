package decaf.frontend.parsing;

import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.lowlevel.StringUtils;

import java.util.List;

/**
 * A semantic value simply simulates a "union" (which we see, e.g. in C++), so that we can store ALL kinds of tree
 * nodes in ONE kind of object.
 * <p>
 * DO NOT use this anywhere else!
 */
class SemValue {
    enum Kind {
        TOKEN, CLASS, CLASS_LIST, FIELD, FIELD_LIST, VAR, VAR_LIST, TYPE, TYPE_LIST, STMT, STMT_LIST, BLOCK, EXPR, EXPR_LIST,
     * Which kind of tree node is this?
     */
    final Kind kind;

    /**
     * The position of this tree node.
     */
    Pos pos;

    /**
     * Maybe you need to store another position?
     */
    Pos pos2;

    /**
     * Create a semantic value.
     *
     * @param kind its kind
     * @param pos  its position
     */
    SemValue(Kind kind, Pos pos) {
        this.kind = kind;
        this.pos = pos;
    }

    // For lexer
    int code;
    int intVal;
    boolean boolVal;
    String strVal;

    /**
     * Create a semantic value for a lexer token, called by {@link AbstractLexer}.
     *
     * @param code the token's code
     * @param pos  its position
     */
    SemValue(int code, Pos pos) {
        this.kind = Kind.TOKEN;
        this.pos = pos;
        this.code = code;
    }

    /**
     * Create a temporary semantic value.
     */
    SemValue() {
        this.kind = Kind.TEMPORARY;
    }

    List<SemValue> thunkList;

    // For parser
    Tree.ClassDef clazz;
    List<Tree.ClassDef> classList;

    Tree.Field field;
    List<Tree.Field> fieldList;

    // a raw var (local/member) is stored using two variables: type, id
    List<Tree.LocalVarDef> varList; // a list can only contain local vars

    Tree.TypeLit type;
    List<Tree.TypeLit> typeList;

    Tree.Stmt stmt;
    List<Tree.Stmt> stmtList;
    List<Tree.TypeLit> typeList;
    Tree.LValue lValue;

    Tree.Id id;

    /**
     * Pretty print SemValue. For debug.
     */
    @Override
    public String toString() {
        String msg = switch (kind) {
            case TOKEN -> switch (code) {
                case Tokens.BOOL -> "keyword  : bool";
                case Tokens.BREAK -> "keyword  : break";
                case Tokens.CLASS -> "keyword  : class";
                case Tokens.ELSE -> "keyword  : else";
                case Tokens.EXTENDS -> "keyword  : extends";
                case Tokens.FOR -> "keyword  : for";
                case Tokens.IF -> "keyword  : if";
                case Tokens.INT -> "keyword  : int";
                case Tokens.VAR -> "keyword  : var";
                case Tokens.INSTANCE_OF -> "keyword : instanceof";
                case Tokens.NEW -> "keyword  : new";
                case Tokens.NULL -> "keyword  : null";
                case Tokens.PRINT -> "keyword  : Print";
                case Tokens.READ_INTEGER -> "keyword  : ReadInteger";
                case Tokens.READ_LINE -> "keyword  : ReadLine";
                case Tokens.VAR -> "keyword  : var";
                case Tokens.WHILE -> "keyword  : while";
                case Tokens.STATIC -> "keyword : static";
                case Tokens.ABSTRACT -> "keyword : abstract";
                case Tokens.FUN -> "keyword : fun";
                case Tokens.INT_LIT -> "int literal : " + intVal;
                case Tokens.BOOL_LIT -> "bool literal : " + boolVal;
                case Tokens.STRING_LIT -> "string literal : " + StringUtils.quote(strVal);
                case Tokens.IDENTIFIER -> "identifier: " + strVal;
                case Tokens.AND -> "operator : &&";
                case Tokens.EQUAL -> "operator : ==";
                case Tokens.GREATER_EQUAL -> "operator : >=";
                case Tokens.LESS_EQUAL -> "operator : <=";
                case Tokens.ABSTRACT -> "keyword : abstract";
                case Tokens.FUN -> "keyword : fun";
            case CLASS -> "CLASS: " + clazz;
            case CLASS_LIST -> "CLASS_LIST: " + classList;
            case FIELD -> "FIELD: " + field;
            case FIELD_LIST -> "FIELD_LIST: " + fieldList;
            case VAR -> "VAR: " + type + " " + id;
            case VAR_LIST -> "VAR_LIST: " + varList;
            case TYPE -> "TYPE: " + type;
            case TYPE_LIST -> "TYPE: " + typeList;
            case STMT -> "STMT: " + stmt;
            case STMT_LIST -> "STMT_LIST: " + stmtList;
                case Tokens.DOUBLE_ARROW -> "operator : =>";
            case ID -> "ID: " + id;
            case TEMPORARY -> "TEMPORARY";
        };
        return String.format("%-9s%s", pos, msg);
    }

    /**
     * A template to write a semantic action in jacc. Given a production of the form
     * <pre>
            case TYPE_LIST -> "TYPE: " + typeList;
     * respectively.
     * <p>
     * If you believe that you can write 100% correct Java code in plain text, then don't care about this.
     */
    private void UserAction(SemValue $$,
                            SemValue $1, SemValue $2, SemValue $3, SemValue $4, SemValue $5, SemValue $6) {
        {
            // Your action
        }
    }
}
