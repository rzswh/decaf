/* This is auto-generated source by LL1-Parser-Gen.
 * Specification file: /home/dflasher/Documents/CompilationLearning/decaf-2017011865/src/main/ll1pg/Decaf.spec
 * Options: unstrict mode
 * Generated at: Tue Oct 08 08:52:33 CST 2019
 * Please do NOT modify it!
 *
 * Project repository: https://github.com/paulzfm/LL1-Parser-Gen
 * Version: decaf-course-19-fall
 * Author: Zhu Fengmin (Paul)
 */

package decaf.frontend.parsing;

import decaf.frontend.tree.Tree.*;
import java.util.*;

public abstract class LLTable extends AbstractParser
{
    public static final int eof = -1;
    public static final int eos = 0;
    
    /* tokens and symbols */
    public static final int VOID = 257; //# line 14
    public static final int BOOL = 258; //# line 14
    public static final int INT = 259; //# line 14
    public static final int STRING = 260; //# line 14
    public static final int CLASS = 261; //# line 14
    public static final int NULL = 262; //# line 15
    public static final int EXTENDS = 263; //# line 15
    public static final int THIS = 264; //# line 15
    public static final int WHILE = 265; //# line 15
    public static final int FOR = 266; //# line 15
    public static final int IF = 267; //# line 16
    public static final int ELSE = 268; //# line 16
    public static final int RETURN = 269; //# line 16
    public static final int BREAK = 270; //# line 16
    public static final int NEW = 271; //# line 16
    public static final int PRINT = 272; //# line 17
    public static final int READ_INTEGER = 273; //# line 17
    public static final int READ_LINE = 274; //# line 17
    public static final int BOOL_LIT = 275; //# line 18
    public static final int INT_LIT = 276; //# line 18
    public static final int STRING_LIT = 277; //# line 18
    public static final int IDENTIFIER = 278; //# line 19
    public static final int AND = 279; //# line 19
    public static final int OR = 280; //# line 19
    public static final int STATIC = 281; //# line 19
    public static final int INSTANCE_OF = 282; //# line 19
    public static final int LESS_EQUAL = 283; //# line 20
    public static final int GREATER_EQUAL = 284; //# line 20
    public static final int EQUAL = 285; //# line 20
    public static final int NOT_EQUAL = 286; //# line 20
    
    public static final int Op6 = 287;
    public static final int ExprT5 = 288;
    public static final int Expr8 = 289;
    public static final int Op4 = 290;
    public static final int Expr2 = 291;
    public static final int TopLevel = 292;
    public static final int Op3 = 293;
    public static final int VarList = 294;
    public static final int Expr6 = 295;
    public static final int ExprT2 = 296;
    public static final int StmtList = 297;
    public static final int Expr9 = 298;
    public static final int Expr1 = 299;
    public static final int ExprListOpt = 300;
    public static final int ElseClause = 301;
    public static final int FieldList = 302;
    public static final int Initializer = 303;
    public static final int AfterParenExpr = 304;
    public static final int ClassDef = 305;
    public static final int ExprList = 306;
    public static final int Op7 = 307;
    public static final int Literal = 308;
    public static final int Op2 = 309;
    public static final int Expr = 310;
    public static final int Id = 311;
    public static final int Type = 312;
    public static final int Expr5 = 313;
    public static final int AfterNewExpr = 314;
    public static final int AtomType = 315;
    public static final int ExtendsClause = 316;
    public static final int ArrayType = 317;
    public static final int ExprOpt = 318;
    public static final int Expr3 = 319;
    public static final int AfterIdField = 320;
    public static final int VarList1 = 321;
    public static final int ExprT3 = 322;
    public static final int Stmt = 323;
    public static final int SimpleStmt = 324;
    public static final int Block = 325;
    public static final int ExprT1 = 326;
    public static final int Expr4 = 327;
    public static final int ExprT4 = 328;
    public static final int AfterLBrack = 329;
    public static final int ExprT6 = 330;
    public static final int Op1 = 331;
    public static final int ExprT8 = 332;
    public static final int ExprList1 = 333;
    public static final int Op5 = 334;
    public static final int Expr7 = 335;
    public static final int ClassList = 336;
    public static final int Var = 337;
    
    /* start symbol */
    public final int start = TopLevel;
    
    /**
      * Judge if a symbol (within valid range) is non-terminal.
      *
      * @param symbol the symbol to be judged.
      * @return true if and only if the symbol is non-terminal.
      */
        
    public boolean isNonTerminal(int symbol) {
        return symbol >= 287;
    }
    
    private final String[] allSymbols = {
        "VOID", "BOOL", "INT", "STRING", "CLASS",
        "NULL", "EXTENDS", "THIS", "WHILE", "FOR",
        "IF", "ELSE", "RETURN", "BREAK", "NEW",
        "PRINT", "READ_INTEGER", "READ_LINE", "BOOL_LIT", "INT_LIT",
        "STRING_LIT", "IDENTIFIER", "AND", "OR", "STATIC",
        "INSTANCE_OF", "LESS_EQUAL", "GREATER_EQUAL", "EQUAL", "NOT_EQUAL",
        "Op6", "ExprT5", "Expr8", "Op4", "Expr2",
        "TopLevel", "Op3", "VarList", "Expr6", "ExprT2",
        "StmtList", "Expr9", "Expr1", "ExprListOpt", "ElseClause",
        "FieldList", "Initializer", "AfterParenExpr", "ClassDef", "ExprList",
        "Op7", "Literal", "Op2", "Expr", "Id",
        "Type", "Expr5", "AfterNewExpr", "AtomType", "ExtendsClause",
        "ArrayType", "ExprOpt", "Expr3", "AfterIdField", "VarList1",
        "ExprT3", "Stmt", "SimpleStmt", "Block", "ExprT1",
        "Expr4", "ExprT4", "AfterLBrack", "ExprT6", "Op1",
        "ExprT8", "ExprList1", "Op5", "Expr7", "ClassList",
        "Var",
    };
    
    /**
      * Debugging function (pretty print).
      * Get string presentation of some token or symbol.
      *
      * @param symbol either terminal or non-terminal.
      * @return its string presentation.
      */
        
    public String name(int symbol) {
        if (symbol == eof) return "<eof>";
        if (symbol == eos) return "<eos>";
        if (symbol > 0 && symbol <= 256) return "'" + (char) symbol + "'";
        return allSymbols[symbol - 257];
    }
    
    /* begin lookahead symbols */
    private ArrayList<Set<Integer>> begin = new ArrayList<Set<Integer>>();
    private final Integer[][] beginRaw = {
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%')},
        {Integer.valueOf('+'), Integer.valueOf('-'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {CLASS},
        {EQUAL, NOT_EQUAL},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {AND, Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, INT_LIT, IDENTIFIER, NEW, STRING_LIT, IF, THIS, STRING, BOOL_LIT, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, BREAK, READ_INTEGER, Integer.valueOf('{'), Integer.valueOf('}')},
        {INT_LIT, BOOL_LIT, STRING_LIT, NULL, THIS, READ_INTEGER, READ_LINE, INSTANCE_OF, NEW, Integer.valueOf('('), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf('('), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {ELSE, PRINT, VOID, FOR, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, INT_LIT, Integer.valueOf('}'), IDENTIFIER, NEW, STRING_LIT, IF, THIS, STRING, BOOL_LIT, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {STATIC, VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('}')},
        {Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER, CLASS},
        {CLASS},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER, Integer.valueOf(')')},
        {Integer.valueOf('-'), Integer.valueOf('!')},
        {INT_LIT, BOOL_LIT, STRING_LIT, NULL},
        {AND},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {IDENTIFIER},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {IDENTIFIER, VOID, CLASS, INT, STRING, BOOL},
        {INT, BOOL, STRING, VOID, CLASS},
        {EXTENDS, Integer.valueOf('{')},
        {Integer.valueOf('['), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf(';'), Integer.valueOf('(')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {EQUAL, NOT_EQUAL, Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf('{'), VOID, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, NULL, INT, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, STRING, BOOL_LIT, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, READ_INTEGER, IF, WHILE, FOR, BREAK, RETURN, PRINT},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER, Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('{')},
        {OR, Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf(']'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {OR},
        {Integer.valueOf('['), Integer.valueOf('.'), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf('+'), Integer.valueOf('-')},
        {Integer.valueOf('-'), Integer.valueOf('!'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {CLASS, eof, eos},
        {VOID, CLASS, INT, STRING, BOOL},
    };
    
    /**
      * Get begin lookahead tokens for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its begin lookahead tokens.
      */
        
    public Set<Integer> beginSet(int symbol) {
        return begin.get(symbol - 287);
    }
    
    /* follow set */
    private ArrayList<Set<Integer>> follow = new ArrayList<Set<Integer>>();
    private final Integer[][] followRaw = {
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf(';')},
        {eof, eos},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf(')')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, INT_LIT, Integer.valueOf('}'), IDENTIFIER, NEW, STRING_LIT, IF, THIS, STRING, BOOL_LIT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('}')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {CLASS, eof, eos},
        {Integer.valueOf(')')},
        {READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, EXTENDS, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, IDENTIFIER, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%'), Integer.valueOf('{')},
        {IDENTIFIER},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('['), IDENTIFIER},
        {Integer.valueOf('{')},
        {IDENTIFIER},
        {Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
        {Integer.valueOf(')')},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, INT_LIT, Integer.valueOf('}'), IDENTIFIER, NEW, STRING_LIT, IF, THIS, STRING, BOOL_LIT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, INT_LIT, Integer.valueOf('}'), IDENTIFIER, NEW, STRING_LIT, IF, THIS, STRING, BOOL_LIT, STATIC, ELSE, Integer.valueOf('('), Integer.valueOf(';'), INSTANCE_OF, BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), Integer.valueOf(')'), Integer.valueOf(','), Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf(']'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(']'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, INT_LIT, IDENTIFIER, NEW, STRING_LIT, THIS, BOOL_LIT, Integer.valueOf('('), INSTANCE_OF, READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf(','), Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
    };
    
    /**
      * Get follow set for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its follow set.
      */
        
    public Set<Integer> followSet(int symbol) {
        return follow.get(symbol - 287);
    }
    
    public LLTable() {
        for (int i = 0; i < 51; i++) {
            begin.add(new HashSet<>(Arrays.asList(beginRaw[i])));
            follow.add(new HashSet<>(Arrays.asList(followRaw[i])));
        }
    }
    
    /**
      * Predictive table `M` query function.
      * `query(A, a)` will return the corresponding term `M(A, a)`, i.e., the target production
      * for non-terminal `A` when the lookahead token is `a`.
      *
      * @param nonTerminal   the non-terminal.
      * @param lookahead     the lookahead symbol.
      * @return a pair `<id, right>` where `right` is the right-hand side of the target
      * production `nonTerminal -> right`, and `id` is the corresponding action id. To execute
      * such action, call `act(id, params)`.
      * If the corresponding term is undefined in the table, `null` will be returned.
      */
        
    public Map.Entry<Integer, List<Integer>> query(int nonTerminal, int lookahead) {
        switch (nonTerminal) {
            //# line 352
            case Op6: {
                switch (lookahead) {
                    case '*':
                        return new AbstractMap.SimpleEntry<>(0, Arrays.asList(Integer.valueOf('*')));
                    case '/':
                        return new AbstractMap.SimpleEntry<>(1, Arrays.asList(Integer.valueOf('/')));
                    case '%':
                        return new AbstractMap.SimpleEntry<>(2, Arrays.asList(Integer.valueOf('%')));
                    default: return null;
                }
            }
            //# line 492
            case ExprT5: {
                switch (lookahead) {
                    case '+':
                    case '-':
                        return new AbstractMap.SimpleEntry<>(3, Arrays.asList(Op5, Expr6, ExprT5));
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(4, Arrays.asList());
                    default: return null;
                }
            }
            //# line 542
            case Expr8: {
                switch (lookahead) {
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(5, Arrays.asList(Expr9, ExprT8));
                    default: return null;
                }
            }
            //# line 312
            case Op4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                        return new AbstractMap.SimpleEntry<>(6, Arrays.asList(LESS_EQUAL));
                    case GREATER_EQUAL:
                        return new AbstractMap.SimpleEntry<>(7, Arrays.asList(GREATER_EQUAL));
                    case '<':
                        return new AbstractMap.SimpleEntry<>(8, Arrays.asList(Integer.valueOf('<')));
                    case '>':
                        return new AbstractMap.SimpleEntry<>(9, Arrays.asList(Integer.valueOf('>')));
                    default: return null;
                }
            }
            //# line 417
            case Expr2: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(10, Arrays.asList(Expr3, ExprT2));
                    default: return null;
                }
            }
            //# line 26
            case TopLevel: {
                switch (lookahead) {
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(11, Arrays.asList(ClassDef, ClassList));
                    default: return null;
                }
            }
            //# line 298
            case Op3: {
                switch (lookahead) {
                    case EQUAL:
                        return new AbstractMap.SimpleEntry<>(12, Arrays.asList(EQUAL));
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(13, Arrays.asList(NOT_EQUAL));
                    default: return null;
                }
            }
            //# line 100
            case VarList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(14, Arrays.asList(Var, VarList1));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(15, Arrays.asList());
                    default: return null;
                }
            }
            //# line 509
            case Expr6: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(16, Arrays.asList(Expr7, ExprT6));
                    default: return null;
                }
            }
            //# line 423
            case ExprT2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(17, Arrays.asList(Op2, Expr3, ExprT2));
                    case ']':
                    case ')':
                    case ',':
                    case '=':
                    case OR:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(18, Arrays.asList());
                    default: return null;
                }
            }
            //# line 215
            case StmtList: {
                switch (lookahead) {
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case IF:
                    case THIS:
                    case STRING:
                    case BOOL_LIT:
                    case '(':
                    case ';':
                    case INSTANCE_OF:
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(19, Arrays.asList(Stmt, StmtList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(20, Arrays.asList());
                    default: return null;
                }
            }
            //# line 598
            case Expr9: {
                switch (lookahead) {
                    case INT_LIT:
                    case BOOL_LIT:
                    case STRING_LIT:
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(21, Arrays.asList(Literal));
                    case THIS:
                        return new AbstractMap.SimpleEntry<>(22, Arrays.asList(THIS));
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(23, Arrays.asList(READ_INTEGER, Integer.valueOf('('), Integer.valueOf(')')));
                    case READ_LINE:
                        return new AbstractMap.SimpleEntry<>(24, Arrays.asList(READ_LINE, Integer.valueOf('('), Integer.valueOf(')')));
                    case INSTANCE_OF:
                        return new AbstractMap.SimpleEntry<>(25, Arrays.asList(INSTANCE_OF, Integer.valueOf('('), Expr, Integer.valueOf(','), Id, Integer.valueOf(')')));
                    case NEW:
                        return new AbstractMap.SimpleEntry<>(26, Arrays.asList(NEW, AfterNewExpr));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(27, Arrays.asList(Integer.valueOf('('), AfterParenExpr));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(28, Arrays.asList(Id, ExprListOpt));
                    default: return null;
                }
            }
            //# line 394
            case Expr1: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(29, Arrays.asList(Expr2, ExprT1));
                    default: return null;
                }
            }
            //# line 587
            case ExprListOpt: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(30, Arrays.asList(Integer.valueOf('('), ExprList, Integer.valueOf(')')));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '.':
                    case '-':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(31, Arrays.asList());
                    default: return null;
                }
            }
            //# line 260
            case ElseClause: {
                switch (lookahead) {
                    case ELSE:
                        return new AbstractMap.SimpleEntry<>(32, Arrays.asList(ELSE, Stmt));
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case INT_LIT:
                    case '}':
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case IF:
                    case THIS:
                    case STRING:
                    case BOOL_LIT:
                    case '(':
                    case ';':
                    case INSTANCE_OF:
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(33, Arrays.asList());
                    default: return null;
                }
            }
            //# line 62
            case FieldList: {
                switch (lookahead) {
                    case STATIC:
                        return new AbstractMap.SimpleEntry<>(34, Arrays.asList(STATIC, Type, Id, Integer.valueOf('('), VarList, Integer.valueOf(')'), Block, FieldList));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(35, Arrays.asList(Type, Id, AfterIdField, FieldList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(36, Arrays.asList());
                    default: return null;
                }
            }
            //# line 249
            case Initializer: {
                switch (lookahead) {
                    case '=':
                        return new AbstractMap.SimpleEntry<>(37, Arrays.asList(Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(38, Arrays.asList());
                    default: return null;
                }
            }
            //# line 684
            case AfterParenExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(39, Arrays.asList(Expr, Integer.valueOf(')')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(40, Arrays.asList(CLASS, Id, Integer.valueOf(')'), Expr9));
                    default: return null;
                }
            }
            //# line 46
            case ClassDef: {
                switch (lookahead) {
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(41, Arrays.asList(CLASS, Id, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 694
            case ExprList: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(42, Arrays.asList(Expr, ExprList1));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(43, Arrays.asList());
                    default: return null;
                }
            }
            //# line 372
            case Op7: {
                switch (lookahead) {
                    case '-':
                        return new AbstractMap.SimpleEntry<>(44, Arrays.asList(Integer.valueOf('-')));
                    case '!':
                        return new AbstractMap.SimpleEntry<>(45, Arrays.asList(Integer.valueOf('!')));
                    default: return null;
                }
            }
            //# line 640
            case Literal: {
                switch (lookahead) {
                    case INT_LIT:
                        return new AbstractMap.SimpleEntry<>(46, Arrays.asList(INT_LIT));
                    case BOOL_LIT:
                        return new AbstractMap.SimpleEntry<>(47, Arrays.asList(BOOL_LIT));
                    case STRING_LIT:
                        return new AbstractMap.SimpleEntry<>(48, Arrays.asList(STRING_LIT));
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(49, Arrays.asList(NULL));
                    default: return null;
                }
            }
            //# line 290
            case Op2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(50, Arrays.asList(AND));
                    default: return null;
                }
            }
            //# line 388
            case Expr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(51, Arrays.asList(Expr1));
                    default: return null;
                }
            }
            //# line 718
            case Id: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(52, Arrays.asList(IDENTIFIER));
                    default: return null;
                }
            }
            //# line 146
            case Type: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(53, Arrays.asList(AtomType, ArrayType));
                    default: return null;
                }
            }
            //# line 486
            case Expr5: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(54, Arrays.asList(Expr6, ExprT5));
                    default: return null;
                }
            }
            //# line 658
            case AfterNewExpr: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(55, Arrays.asList(Id, Integer.valueOf('('), Integer.valueOf(')')));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(56, Arrays.asList(AtomType, Integer.valueOf('['), AfterLBrack));
                    default: return null;
                }
            }
            //# line 124
            case AtomType: {
                switch (lookahead) {
                    case INT:
                        return new AbstractMap.SimpleEntry<>(57, Arrays.asList(INT));
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(58, Arrays.asList(BOOL));
                    case STRING:
                        return new AbstractMap.SimpleEntry<>(59, Arrays.asList(STRING));
                    case VOID:
                        return new AbstractMap.SimpleEntry<>(60, Arrays.asList(VOID));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(61, Arrays.asList(CLASS, Id));
                    default: return null;
                }
            }
            //# line 52
            case ExtendsClause: {
                switch (lookahead) {
                    case EXTENDS:
                        return new AbstractMap.SimpleEntry<>(62, Arrays.asList(EXTENDS, Id));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(63, Arrays.asList());
                    default: return null;
                }
            }
            //# line 155
            case ArrayType: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(64, Arrays.asList(Integer.valueOf('['), Integer.valueOf(']'), ArrayType));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(65, Arrays.asList());
                    default: return null;
                }
            }
            //# line 270
            case ExprOpt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(66, Arrays.asList(Expr));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(67, Arrays.asList());
                    default: return null;
                }
            }
            //# line 440
            case Expr3: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(68, Arrays.asList(Expr4, ExprT3));
                    default: return null;
                }
            }
            //# line 82
            case AfterIdField: {
                switch (lookahead) {
                    case ';':
                        return new AbstractMap.SimpleEntry<>(69, Arrays.asList(Integer.valueOf(';')));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(70, Arrays.asList(Integer.valueOf('('), VarList, Integer.valueOf(')'), Block));
                    default: return null;
                }
            }
            //# line 111
            case VarList1: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(71, Arrays.asList(Integer.valueOf(','), Var, VarList1));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(72, Arrays.asList());
                    default: return null;
                }
            }
            //# line 446
            case ExprT3: {
                switch (lookahead) {
                    case EQUAL:
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(73, Arrays.asList(Op3, Expr4, ExprT3));
                    case ']':
                    case ')':
                    case ',':
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(74, Arrays.asList());
                    default: return null;
                }
            }
            //# line 169
            case Stmt: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(75, Arrays.asList(Block));
                    case VOID:
                    case '!':
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case NULL:
                    case INT:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case STRING:
                    case BOOL_LIT:
                    case '(':
                    case ';':
                    case INSTANCE_OF:
                    case BOOL:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(76, Arrays.asList(SimpleStmt, Integer.valueOf(';')));
                    case IF:
                        return new AbstractMap.SimpleEntry<>(77, Arrays.asList(IF, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt, ElseClause));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(78, Arrays.asList(WHILE, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt));
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(79, Arrays.asList(FOR, Integer.valueOf('('), SimpleStmt, Integer.valueOf(';'), Expr, Integer.valueOf(';'), SimpleStmt, Integer.valueOf(')'), Stmt));
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(80, Arrays.asList(BREAK, Integer.valueOf(';')));
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(81, Arrays.asList(RETURN, ExprOpt, Integer.valueOf(';')));
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(82, Arrays.asList(PRINT, Integer.valueOf('('), ExprList, Integer.valueOf(')'), Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 226
            case SimpleStmt: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(83, Arrays.asList(Var, Initializer));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(84, Arrays.asList(Expr, Initializer));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(85, Arrays.asList());
                    default: return null;
                }
            }
            //# line 209
            case Block: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(86, Arrays.asList(Integer.valueOf('{'), StmtList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 400
            case ExprT1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(87, Arrays.asList(Op1, Expr2, ExprT1));
                    case ']':
                    case ')':
                    case ',':
                    case '=':
                    case ';':
                        return new AbstractMap.SimpleEntry<>(88, Arrays.asList());
                    default: return null;
                }
            }
            //# line 463
            case Expr4: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(89, Arrays.asList(Expr5, ExprT4));
                    default: return null;
                }
            }
            //# line 469
            case ExprT4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                    case GREATER_EQUAL:
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(90, Arrays.asList(Op4, Expr5, ExprT4));
                    case ']':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(91, Arrays.asList());
                    default: return null;
                }
            }
            //# line 672
            case AfterLBrack: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(92, Arrays.asList(Integer.valueOf(']'), Integer.valueOf('['), AfterLBrack));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(93, Arrays.asList(Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 515
            case ExprT6: {
                switch (lookahead) {
                    case '*':
                    case '/':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(94, Arrays.asList(Op6, Expr7, ExprT6));
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '-':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(95, Arrays.asList());
                    default: return null;
                }
            }
            //# line 282
            case Op1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(96, Arrays.asList(OR));
                    default: return null;
                }
            }
            //# line 558
            case ExprT8: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(97, Arrays.asList(Integer.valueOf('['), Expr, Integer.valueOf(']'), ExprT8));
                    case '.':
                        return new AbstractMap.SimpleEntry<>(98, Arrays.asList(Integer.valueOf('.'), Id, ExprListOpt, ExprT8));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '-':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(99, Arrays.asList());
                    default: return null;
                }
            }
            //# line 705
            case ExprList1: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(100, Arrays.asList(Integer.valueOf(','), Expr, ExprList1));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(101, Arrays.asList());
                    default: return null;
                }
            }
            //# line 338
            case Op5: {
                switch (lookahead) {
                    case '+':
                        return new AbstractMap.SimpleEntry<>(102, Arrays.asList(Integer.valueOf('+')));
                    case '-':
                        return new AbstractMap.SimpleEntry<>(103, Arrays.asList(Integer.valueOf('-')));
                    default: return null;
                }
            }
            //# line 532
            case Expr7: {
                switch (lookahead) {
                    case '-':
                    case '!':
                        return new AbstractMap.SimpleEntry<>(104, Arrays.asList(Op7, Expr8));
                    case READ_LINE:
                    case NULL:
                    case INT_LIT:
                    case IDENTIFIER:
                    case NEW:
                    case STRING_LIT:
                    case THIS:
                    case BOOL_LIT:
                    case '(':
                    case INSTANCE_OF:
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(105, Arrays.asList(Expr8));
                    default: return null;
                }
            }
            //# line 35
            case ClassList: {
                switch (lookahead) {
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(106, Arrays.asList(ClassDef, ClassList));
                    case eof:
                    case eos:
                        return new AbstractMap.SimpleEntry<>(107, Arrays.asList());
                    default: return null;
                }
            }
            //# line 94
            case Var: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(108, Arrays.asList(Type, Id));
                    default: return null;
                }
            }
            default: return null;
        }
    }
    
    /**
      * Execute some user-defined semantic action on the specification file.
      * Note that `$$ = params[0], $1 = params[1], ...`. Nothing will be returned, so please
      * do not forget to store the parsed AST result in `params[0]`.
      *
      * @param id      the action id.
      * @param params  parameter array.
      */
        
    public void act(int id, SemValue[] params) {
        switch (id) {
            case 0: {
                //# line 353
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.MUL.ordinal();
                return;
            }
            case 1: {
                //# line 359
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.DIV.ordinal();
                return;
            }
            case 2: {
                //# line 365
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.MOD.ordinal();
                return;
            }
            case 3: {
                //# line 493
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 4: {
                //# line 503
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 5: {
                //# line 543
                params[0] = params[1];
                for (var sv : params[2].thunkList) {
                    if (sv.expr != null) {
                        params[0] = svExpr(new IndexSel(params[0].expr, sv.expr, sv.pos));
                    } else if (sv.exprList != null) {
                        params[0] = svExpr(new Call(params[0].expr, sv.id, sv.exprList, sv.pos));
                    } else {
                        params[0] = svExpr(new VarSel(params[0].expr, sv.id, sv.pos));
                    }
                }
                params[0].pos = params[0].expr.pos;
                return;
            }
            case 6: {
                //# line 313
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.LE.ordinal();
                return;
            }
            case 7: {
                //# line 319
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.GE.ordinal();
                return;
            }
            case 8: {
                //# line 325
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.LT.ordinal();
                return;
            }
            case 9: {
                //# line 331
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.GT.ordinal();
                return;
            }
            case 10: {
                //# line 418
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 11: {
                //# line 27
                params[0] = svClasses(params[1].clazz);
                params[0].classList.addAll(params[2].classList);
                tree = new TopLevel(params[0].classList, params[0].pos);
                return;
            }
            case 12: {
                //# line 299
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.EQ.ordinal();
                return;
            }
            case 13: {
                //# line 305
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.NE.ordinal();
                return;
            }
            case 14: {
                //# line 101
                params[0] = params[2];
                params[0].varList.add(0, new LocalVarDef(params[1].type, params[1].id, params[1].pos));
                return;
            }
            case 15: {
                //# line 106
                params[0] = svVars();
                return;
            }
            case 16: {
                //# line 510
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 17: {
                //# line 424
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 18: {
                //# line 434
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 19: {
                //# line 216
                params[0] = params[2];
                params[0].stmtList.add(0, params[1].stmt);
                return;
            }
            case 20: {
                //# line 221
                params[0] = svStmts();
                return;
            }
            case 21: {
                //# line 599
                params[0] = params[1];
                return;
            }
            case 22: {
                //# line 603
                params[0] = svExpr(new This(params[1].pos));
                return;
            }
            case 23: {
                //# line 607
                params[0] = svExpr(new ReadInt(params[1].pos));
                return;
            }
            case 24: {
                //# line 611
                params[0] = svExpr(new ReadLine(params[1].pos));
                return;
            }
            case 25: {
                //# line 615
                params[0] = svExpr(new ClassTest(params[3].expr, params[5].id, params[1].pos));
                return;
            }
            case 26: {
                //# line 619
                if (params[2].id != null) {
                    params[0] = svExpr(new NewClass(params[2].id, params[1].pos));
                } else {
                    params[0] = svExpr(new NewArray(params[2].type, params[2].expr, params[1].pos));
                }
                return;
            }
            case 27: {
                //# line 627
                params[0] = params[2];
                return;
            }
            case 28: {
                //# line 631
                if (params[2].exprList != null) {
                    params[0] = svExpr(new Call(params[1].id, params[2].exprList, params[2].pos));
                } else {
                    params[0] = svExpr(new VarSel(params[1].id, params[1].pos));
                }
                return;
            }
            case 29: {
                //# line 395
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 30: {
                //# line 588
                params[0] = params[2];
                params[0].pos = params[1].pos;
                return;
            }
            case 31: {
                //# line 593
                params[0] = new SemValue();
                return;
            }
            case 32: {
                //# line 261
                params[0] = params[2];
                return;
            }
            case 33: {
                //# line 265
                params[0] = svStmt(null);
                return;
            }
            case 34: {
                //# line 63
                params[0] = params[8];
                params[0].fieldList.add(0, new MethodDef(true, params[3].id, params[2].type, params[5].varList, params[7].block, params[3].pos));
                return;
            }
            case 35: {
                //# line 68
                params[0] = params[4];
                if (params[3].varList != null) {
                    params[0].fieldList.add(0, new MethodDef(false, params[2].id, params[1].type, params[3].varList, params[3].block, params[2].pos));
                } else {
                    params[0].fieldList.add(0, new VarDef(params[1].type, params[2].id, params[2].pos));
                }
                return;
            }
            case 36: {
                //# line 77
                params[0] = svFields();
                return;
            }
            case 37: {
                //# line 250
                params[0] = svExpr(params[2].expr);
                params[0].pos = params[1].pos;
                return;
            }
            case 38: {
                //# line 255
                params[0] = svExpr(null);
                return;
            }
            case 39: {
                //# line 685
                params[0] = params[1];
                return;
            }
            case 40: {
                //# line 689
                params[0] = svExpr(new ClassCast(params[4].expr, params[2].id, params[4].pos));
                return;
            }
            case 41: {
                //# line 47
                params[0] = svClass(new ClassDef(params[2].id, Optional.ofNullable(params[3].id), params[5].fieldList, params[1].pos));
                return;
            }
            case 42: {
                //# line 695
                params[0] = params[2];
                params[0].exprList.add(0, params[1].expr);
                return;
            }
            case 43: {
                //# line 700
                params[0] = svExprs();
                return;
            }
            case 44: {
                //# line 373
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = UnaryOp.NEG.ordinal();
                return;
            }
            case 45: {
                //# line 379
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = UnaryOp.NOT.ordinal();
                return;
            }
            case 46: {
                //# line 641
                params[0] = svExpr(new IntLit(params[1].intVal, params[1].pos));
                return;
            }
            case 47: {
                //# line 645
                params[0] = svExpr(new BoolLit(params[1].boolVal, params[1].pos));
                return;
            }
            case 48: {
                //# line 649
                params[0] = svExpr(new StringLit(params[1].strVal, params[1].pos));
                return;
            }
            case 49: {
                //# line 653
                params[0] = svExpr(new NullLit(params[1].pos));
                return;
            }
            case 50: {
                //# line 291
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.AND.ordinal();
                return;
            }
            case 51: {
                //# line 389
                params[0] = params[1];
                return;
            }
            case 52: {
                //# line 719
                params[0] = svId(new Id(params[1].strVal, params[1].pos));
                return;
            }
            case 53: {
                //# line 147
                params[0] = params[1];
                for (int i = 0; i < params[2].intVal; i++) {
                    params[0].type = new TArray(params[0].type, params[1].type.pos);
                }
                return;
            }
            case 54: {
                //# line 487
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 55: {
                //# line 659
                params[0] = svId(params[1].id);
                return;
            }
            case 56: {
                //# line 663
                params[0] = params[1];
                for (int i = 0; i < params[3].intVal; i++) {
                    params[0].type = new TArray(params[0].type, params[1].pos);
                }
                params[0].expr = params[3].expr;
                return;
            }
            case 57: {
                //# line 125
                params[0] = svType(new TInt(params[1].pos));
                return;
            }
            case 58: {
                //# line 129
                params[0] = svType(new TBool(params[1].pos));
                return;
            }
            case 59: {
                //# line 133
                params[0] = svType(new TString(params[1].pos));
                return;
            }
            case 60: {
                //# line 137
                params[0] = svType(new TVoid(params[1].pos));
                return;
            }
            case 61: {
                //# line 141
                params[0] = svType(new TClass(params[2].id, params[1].pos));
                return;
            }
            case 62: {
                //# line 53
                params[0] = params[2];
                return;
            }
            case 63: {
                //# line 57
                params[0] = svId(null);
                return;
            }
            case 64: {
                //# line 156
                params[0] = params[3];
                params[0].intVal++;
                return;
            }
            case 65: {
                //# line 161
                params[0] = new SemValue();
                params[0].intVal = 0; // counter
                return;
            }
            case 66: {
                //# line 271
                params[0] = params[1];
                return;
            }
            case 67: {
                //# line 275
                params[0] = svExpr(null);
                return;
            }
            case 68: {
                //# line 441
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 69: {
                //# line 83
                params[0] = new SemValue();
                return;
            }
            case 70: {
                //# line 87
                params[0] = new SemValue();
                params[0].varList = params[2].varList;
                params[0].block = params[4].block;
                return;
            }
            case 71: {
                //# line 112
                params[0] = params[3];
                params[0].varList.add(0, new LocalVarDef(params[2].type, params[2].id, params[2].pos));
                return;
            }
            case 72: {
                //# line 117
                params[0] = svVars();
                return;
            }
            case 73: {
                //# line 447
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 74: {
                //# line 457
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 75: {
                //# line 170
                params[0] = svStmt(params[1].block);
                return;
            }
            case 76: {
                //# line 174
                if (params[1].stmt == null) {
                    params[0] = svStmt(new Skip(params[2].pos));
                } else {
                    params[0] = params[1];
                }
                return;
            }
            case 77: {
                //# line 182
                params[0] = svStmt(new If(params[3].expr, params[5].stmt, Optional.ofNullable(params[6].stmt), params[1].pos));
                return;
            }
            case 78: {
                //# line 186
                params[0] = svStmt(new While(params[3].expr, params[5].stmt, params[1].pos));
                return;
            }
            case 79: {
                //# line 190
                if (params[3].stmt == null) params[3].stmt = new Skip(params[4].pos);
                if (params[7].stmt == null) params[7].stmt = new Skip(params[8].pos);
                params[0] = svStmt(new For(params[3].stmt, params[5].expr, params[7].stmt, params[9].stmt, params[1].pos));
                return;
            }
            case 80: {
                //# line 196
                params[0] = svStmt(new Break(params[1].pos));
                return;
            }
            case 81: {
                //# line 200
                params[0] = svStmt(new Return(Optional.ofNullable(params[2].expr), params[1].pos));
                return;
            }
            case 82: {
                //# line 204
                params[0] = svStmt(new Print(params[3].exprList, params[1].pos));
                return;
            }
            case 83: {
                //# line 227
                params[0] = svStmt(new LocalVarDef(params[1].type, params[1].id, params[2].pos, Optional.ofNullable(params[2].expr), params[1].pos));
                return;
            }
            case 84: {
                //# line 231
                if (params[2].expr != null) {
                    if (params[1].expr instanceof LValue) {
                        var lv = (LValue) params[1].expr;
                        params[0] = svStmt(new Assign(lv, params[2].expr, params[2].pos));
                    } else {
                        yyerror("syntax error");
                    }
                } else {
                    params[0] = svStmt(new ExprEval(params[1].expr, params[1].pos));
                }
                return;
            }
            case 85: {
                //# line 244
                params[0] = svStmt(null);
                return;
            }
            case 86: {
                //# line 210
                params[0] = svBlock(new Block(params[2].stmtList, params[1].pos));
                return;
            }
            case 87: {
                //# line 401
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 88: {
                //# line 411
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 89: {
                //# line 464
                params[0] = buildBinaryExpr(params[1], params[2].thunkList);
                return;
            }
            case 90: {
                //# line 470
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 91: {
                //# line 480
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 92: {
                //# line 673
                params[0] = params[3];
                params[0].intVal++;
                return;
            }
            case 93: {
                //# line 678
                params[0] = svExpr(params[1].expr);
                params[0].intVal = 0; // counter
                return;
            }
            case 94: {
                //# line 516
                var sv = new SemValue();
                sv.code = params[1].code;
                sv.pos = params[1].pos;
                sv.expr = params[2].expr;
                params[0] = params[3];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 95: {
                //# line 526
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 96: {
                //# line 283
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.OR.ordinal();
                return;
            }
            case 97: {
                //# line 559
                var sv = new SemValue();
                sv.expr = params[2].expr;
                sv.pos = params[1].pos;
                params[0] = params[4];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 98: {
                //# line 568
                var sv = new SemValue();
                sv.id = params[2].id;
                sv.pos = params[2].pos;
                if (params[3].exprList != null) {
                    sv.exprList = params[3].exprList;
                    sv.pos = params[3].pos;
                }
                params[0] = params[4];
                params[0].thunkList.add(0, sv);
                return;
            }
            case 99: {
                //# line 581
                params[0] = new SemValue();
                params[0].thunkList = new ArrayList<>();
                return;
            }
            case 100: {
                //# line 706
                params[0] = params[3];
                params[0].exprList.add(0, params[2].expr);
                return;
            }
            case 101: {
                //# line 711
                params[0] = svExprs();
                return;
            }
            case 102: {
                //# line 339
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.ADD.ordinal();
                return;
            }
            case 103: {
                //# line 345
                params[0] = new SemValue();
                params[0].pos = params[1].pos;
                params[0].code = BinaryOp.SUB.ordinal();
                return;
            }
            case 104: {
                //# line 533
                params[0] = svExpr(new Unary(UnaryOp.values()[params[1].code], params[2].expr, params[1].pos));
                return;
            }
            case 105: {
                //# line 537
                params[0] = params[1];
                return;
            }
            case 106: {
                //# line 36
                params[0] = params[2];
                params[0].classList.add(0, params[1].clazz);
                return;
            }
            case 107: {
                //# line 41
                params[0] = svClasses();
                return;
            }
            case 108: {
                //# line 95
                params[0] = svVar(params[1].type, params[2].id, params[2].pos);
                return;
            }
        }
    }
}
/* end of file */
