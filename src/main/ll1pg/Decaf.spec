// Decaf LL(1) grammar

%package decaf.frontend.parsing
%import
decaf.frontend.tree.Tree.*
java.util.*

%class public abstract class LLTable extends AbstractParser
%output "LLTable.java"
%sem SemValue
%start TopLevel

%tokens
VOID         BOOL        INT         STRING      CLASS
NULL         EXTENDS     THIS        WHILE       FOR
IF           ELSE        RETURN      BREAK       NEW
PRINT        READ_INTEGER            READ_LINE
BOOL_LIT     INT_LIT     STRING_LIT  ABSTRACT
IDENTIFIER   AND         OR          STATIC      INSTANCE_OF
LESS_EQUAL   GREATER_EQUAL           EQUAL       NOT_EQUAL
'+'  '-'  '*'  '/'  '%'  '='  '>'  '<'  '.'
','  ';'  '!'  '('  ')'  '['  ']'  '{'  '}'
DOUBLE_ARROW FUN         VAR

%%

TopLevel        :   ClassDef ClassList
                    {
                        $$ = svClasses($1.clazz);
                        $$.classList.addAll($2.classList);

                        tree = new TopLevel($$.classList, $$.pos);
                    }
                ;

ClassList       :   ClassDef ClassList
                    {
                        $$ = $2;
                        $$.classList.add(0, $1.clazz);
                    }
                |   /* empty */
                    {
                        $$ = svClasses();
                    }
                ;

ClassDef        :   CLASS Id ExtendsClause '{' FieldList '}'
                    {
                        $$ = svClass(new ClassDef(false, $2.id, Optional.ofNullable($3.id), $5.fieldList, $1.pos));
                    }
                |   ABSTRACT CLASS Id ExtendsClause '{' FieldList '}'
                    {
                        $$ = svClass(new ClassDef(true, $3.id, Optional.ofNullable($4.id), $6.fieldList, $2.pos));
                    }
                ;

ExtendsClause   :   EXTENDS Id
                    {
                        $$ = $2;
                    }
                |   /* empty */
                    {
                        $$ = svId(null);
                    }
                ;

FieldList       :   ABSTRACT Type Id '(' VarList ')' ';' FieldList
                    {
                        $$ = $8;
                        $$.fieldList.add(0, new MethodDef(true, false, $3.id, $2.type, $5.varList, null, $3.pos));
                    }
                |   STATIC Type Id '(' VarList ')' Block FieldList
                    {
                        $$ = $8;
                        $$.fieldList.add(0, new MethodDef(false, true, $3.id, $2.type, $5.varList, $7.block, $3.pos));
                    }
                |   Type Id AfterIdField FieldList
                    {
                        $$ = $4;
                        if ($3.varList != null) {
                            $$.fieldList.add(0, new MethodDef(false, false, $2.id, $1.type, $3.varList, $3.block, $2.pos));
                        } else {
                            $$.fieldList.add(0, new VarDef($1.type, $2.id, $2.pos));
                        }
                    }
                |   /* empty */
                    {
                        $$ = svFields();
                    }
                ;

AfterIdField    :   ';'
                    {
                        $$ = new SemValue();
                    }
                |   '(' VarList ')' Block
                    {
                        $$ = new SemValue();
                        $$.varList = $2.varList;
                        $$.block = $4.block;
                    }
                ;

Var             :   Type Id
                    {
                        $$ = svVar($1.type, $2.id, $2.pos);
                    }
                ;

VarList         :   Var VarList1
                    {
                        $$ = $2;
                        $$.varList.add(0, new LocalVarDef($1.type, $1.id, $1.pos));
                    }
                |   /* empty */
                    {
                        $$ = svVars();
                    }
                ;

VarList1        :   ',' Var VarList1
                    {
                        $$ = $3;
                        $$.varList.add(0, new LocalVarDef($2.type, $2.id, $2.pos));
                    }
                |   /* empty */
                    {
                        $$ = svVars();
                    }
                ;

// Types

AtomType        :   INT
                    {
                        $$ = svType(new TInt($1.pos));
                    }
                |   BOOL
                    {
                        $$ = svType(new TBool($1.pos));
                    }
                |   STRING
                    {
                        $$ = svType(new TString($1.pos));
                    }
                |   VOID
                    {
                        $$ = svType(new TVoid($1.pos));
                    }
                |   CLASS Id
                    {
                        $$ = svType(new TClass($2.id, $1.pos));
                    }
                ;

Type            :   AtomType TypeFollow
                    {
                        $$ = $1;
                        for (SemValue v: $2.thunkList) {
                            if (v.intVal == 1)
                                $$.type = new TArray($$.type, $1.pos);
                            else if (v.intVal == 2)
                                $$.type = new TLambda($$.type, v.typeList, $1.pos);
                            else {
                                // v.intVal == 0
                            }
                        }
                    }
                ;

TypeList        :   Type TypeList1
                    {
                        $$ = $2;
                        $2.typeList.add(0, $1.type);
                    }
                |   /* empty */
                    {
                        $$ = svTypes();
                    }
                ;

TypeList1       :   ',' Type TypeList1
                    {
                        $$ = $3;
                        $3.typeList.add(0, $2.type);
                    }
                |   /* empty */
                    {
                        $$ = svTypes();
                    }
                ;

TypeFollow       :   '[' ']' TypeFollow
                    {
                        var sv = new SemValue();
                        sv.intVal = 1;

                        $$ = $3;
                        $3.thunkList.add(0, sv);
                    }
                |   '(' TypeList ')' TypeFollow
                    {
                        var sv = new SemValue();
                        sv.intVal = 2;
                        sv.typeList = $2.typeList;

                        $$ = $4;
                        $4.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

// Statements

Stmt            :   Block
                    {
                        $$ = svStmt($1.block);
                    }
                |   SimpleStmt ';'
                    {
                        if ($1.stmt == null) {
                            $$ = svStmt(new Skip($2.pos));
                        } else {
                            $$ = $1;
                        }
                    }
                |   IF '(' Expr ')' Stmt ElseClause
                    {
                        $$ = svStmt(new If($3.expr, $5.stmt, Optional.ofNullable($6.stmt), $1.pos));
                    }
                |   WHILE '(' Expr ')' Stmt
                    {
                        $$ = svStmt(new While($3.expr, $5.stmt, $1.pos));
                    }
                |   FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt
                    {
                        if ($3.stmt == null) $3.stmt = new Skip($4.pos);
                        if ($7.stmt == null) $7.stmt = new Skip($8.pos);
                        $$ = svStmt(new For($3.stmt, $5.expr, $7.stmt, $9.stmt, $1.pos));
                    }
                |   BREAK ';'
                    {
                        $$ = svStmt(new Break($1.pos));
                    }
                |   RETURN ExprOpt ';'
                    {
                        $$ = svStmt(new Return(Optional.ofNullable($2.expr), $1.pos));
                    }
                |   PRINT '(' ExprList ')' ';'
                    {
                        $$ = svStmt(new Print($3.exprList, $1.pos));
                    }
                ;

Block           :   '{' StmtList '}'
                    {
                        $$ = svBlock(new Block($2.stmtList, $1.pos));
                    }
                ;

StmtList        :   Stmt StmtList
                    {
                        $$ = $2;
                        $$.stmtList.add(0, $1.stmt);
                    }
                |   /* empty */
                    {
                        $$ = svStmts();
                    }
                ;

SimpleStmt      :   Var Initializer
                    {
                        $$ = svStmt(new LocalVarDef($1.type, $1.id, $2.pos, Optional.ofNullable($2.expr), $1.pos));
                    }
                |   Expr Initializer
                    {
                        if ($2.expr != null) {
                            if ($1.expr instanceof LValue) {
                                var lv = (LValue) $1.expr;
                                $$ = svStmt(new Assign(lv, $2.expr, $2.pos));
                            } else {
                                yyerror("syntax error");
                            }
                        } else {
                            $$ = svStmt(new ExprEval($1.expr, $1.pos));
                        }
                    }
                |   /* empty */
                    {
                        $$ = svStmt(null);
                    }
                |   VAR Id '=' Expr
                    {
                        $$ = svStmt(new LocalVarDef(null, $2.id, $3.pos, Optional.ofNullable($4.expr), $2.pos));
                    }
                ;

Initializer     :   '=' Expr
                    {
                        $$ = svExpr($2.expr);
                        $$.pos = $1.pos;
                    }
                |   /* empty */
                    {
                        $$ = svExpr(null);
                    }
                ;

ElseClause      :   ELSE Stmt // higher priority, which triggers a warning (that is expected)
                    {
                        $$ = $2;
                    }
                |   /* empty */
                    {
                        $$ = svStmt(null);
                    }
                ;

ExprOpt         :   Expr
                    {
                        $$ = $1;
                    }
                |   /* empty */
                    {
                        $$ = svExpr(null);
                    }
                ;

// Operators

Op1             :   OR
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.OR.ordinal();
                    }
                ;

Op2             :   AND
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.AND.ordinal();
                    }
                ;

Op3             :   EQUAL
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.EQ.ordinal();
                    }
                |   NOT_EQUAL
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.NE.ordinal();
                    }
                ;

Op4             :   LESS_EQUAL
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.LE.ordinal();
                    }
                |   GREATER_EQUAL
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.GE.ordinal();
                    }
                |   '<'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.LT.ordinal();
                    }
                |   '>'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.GT.ordinal();
                    }
                ;

Op5             :   '+'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.ADD.ordinal();
                    }
                |   '-'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.SUB.ordinal();
                    }
                ;

Op6           :   '*'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.MUL.ordinal();
                    }
                |   '/'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.DIV.ordinal();
                    }
                |   '%'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = BinaryOp.MOD.ordinal();
                    }
                ;

Op7             :   '-'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = UnaryOp.NEG.ordinal();
                    }
                |   '!'
                    {
                        $$ = new SemValue();
                        $$.pos = $1.pos;
                        $$.code = UnaryOp.NOT.ordinal();
                    }
                ;

// Expressions

Expr            :   Expr1
                    {
                        $$ = $1;
                    }
                |   ExprLambda
                    {
                        $$ = $1;
                    }
                ;

Expr1           :   Expr2 ExprT1
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprLambda      :   FUN '(' VarList ')' LambdaBody
                    {
                        if ($5.expr != null)
                            $$ = svExpr(new LambdaExpr($3.varList, $5.expr, $1.pos));
                        else if ($5.block != null)
                            $$ = svExpr(new LambdaBlock($3.varList, $5.block, $1.pos));
                        else
                            $$ = svExpr(null);
                    }
                ;

LambdaBody      :   DOUBLE_ARROW Expr
                    {
                        $$ = new SemValue();
                        $$.expr = $2.expr;
                    }
                |   Block
                    {
                        $$ = new SemValue();
                        $$.block = $1.block;
                    }
                ;

ExprT1          :   Op1 Expr2 ExprT1
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr2           :   Expr3 ExprT2
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprT2          :   Op2 Expr3 ExprT2
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr3           :   Expr4 ExprT3
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprT3          :   Op3 Expr4 ExprT3
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr4           :   Expr5 ExprT4
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprT4          :   Op4 Expr5 ExprT4
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr5           :   Expr6 ExprT5
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprT5          :   Op5 Expr6 ExprT5
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr6           :   Expr7 ExprT6
                    {
                        $$ = buildBinaryExpr($1, $2.thunkList);
                    }
                ;

ExprT6          :   Op6 Expr7 ExprT6
                    {
                        var sv = new SemValue();
                        sv.code = $1.code;
                        sv.pos = $1.pos;
                        sv.expr = $2.expr;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr7           :   Op7 Expr8
                    {
                        $$ = svExpr(new Unary(UnaryOp.values()[$1.code], $2.expr, $1.pos));
                    }
                |   Expr8
                    {
                        $$ = $1;
                    }
                ;

Expr8           :   Expr9 ExprT8
                    {
                        $$ = $1;
                        for (var sv : $2.thunkList) {
                            if (sv.expr != null) {
                                $$ = svExpr(new IndexSel($$.expr, sv.expr, sv.pos));
                            } else if (sv.exprList != null) {
                                $$ = svExpr(new Call($$.expr, sv.exprList, sv.pos));
                            } else {
                                $$ = svExpr(new VarSel($$.expr, sv.id, sv.pos));
                            }
                        }
                        $$.pos = $$.expr.pos;
                    }
                ;

ExprT8          :   '[' Expr ']' ExprT8
                    {
                        var sv = new SemValue();
                        sv.expr = $2.expr;
                        sv.pos = $1.pos;

                        $$ = $4;
                        $$.thunkList.add(0, sv);
                    }
                |   '.' Id ExprT8
                    {
                        var sv = new SemValue();
                        sv.id = $2.id;
                        sv.pos = $2.pos;

                        $$ = $3;
                        $$.thunkList.add(0, sv);
                    }
                |   '(' ExprList ')' ExprT8
                    {
                        var sv = new SemValue();
                        if ($2.exprList != null) {
                            sv.exprList = $2.exprList;
                            sv.pos = $1.pos;
                        }

                        $$ = $4;
                        $$.thunkList.add(0, sv);
                    }
                |   /* empty */
                    {
                        $$ = new SemValue();
                        $$.thunkList = new ArrayList<>();
                    }
                ;

Expr9           :   Literal
                    {
                        $$ = $1;
                    }
                |   THIS
                    {
                        $$ = svExpr(new This($1.pos));
                    }
                |   READ_INTEGER '(' ')'
                    {
                        $$ = svExpr(new ReadInt($1.pos));
                    }
                |   READ_LINE '(' ')'
                    {
                        $$ = svExpr(new ReadLine($1.pos));
                    }
                |   INSTANCE_OF '(' Expr ',' Id ')'
                    {
                        $$ = svExpr(new ClassTest($3.expr, $5.id, $1.pos));
                    }
                |   NEW AfterNewExpr
                    {
                        if ($2.id != null) {
                            $$ = svExpr(new NewClass($2.id, $1.pos));
                        } else {
                            $$ = svExpr(new NewArray($2.type, $2.expr, $1.pos));
                        }
                    }
                |   '(' AfterParenExpr
                    {
                        $$ = $2;
                    }
                |   Id
                    {
                        $$ = svExpr(new VarSel($1.id, $1.pos));
                    }
                ;

Literal         :   INT_LIT
                    {
                        $$ = svExpr(new IntLit($1.intVal, $1.pos));
                    }
                |   BOOL_LIT
                    {
                        $$ = svExpr(new BoolLit($1.boolVal, $1.pos));
                    }
                |   STRING_LIT
                    {
                        $$ = svExpr(new StringLit($1.strVal, $1.pos));
                    }
                |   NULL
                    {
                        $$ = svExpr(new NullLit($1.pos));
                    }
                ;

AfterNewExpr    :   Id '(' ')'
                    {
                        $$ = svId($1.id);
                    }
                |   AtomType '[' AfterLBrack
                    {
                        $$ = $1;
                        for (int i = 0; i < $3.intVal; i++) {
                            $$.type = new TArray($$.type, $1.pos);
                        }
                        $$.expr = $3.expr;
                    }
                ;

AfterLBrack     :   ']' '[' AfterLBrack
                    {
                        $$ = $3;
                        $$.intVal++;
                    }
                |   Expr ']'
                    {
                        $$ = svExpr($1.expr);
                        $$.intVal = 0; // counter
                    }
                ;

AfterParenExpr  :   Expr ')'
                    {
                        $$ = $1;
                    }
                |   CLASS Id ')' Expr9
                    {
                        $$ = svExpr(new ClassCast($4.expr, $2.id, $4.pos));
                    }
                ;

ExprList        :   Expr ExprList1
                    {
                        $$ = $2;
                        $$.exprList.add(0, $1.expr);
                    }
                |   /* empty */
                    {
                        $$ = svExprs();
                    }
                ;

ExprList1       :   ',' Expr ExprList1
                    {
                        $$ = $3;
                        $$.exprList.add(0, $2.expr);
                    }
                |   /* empty */
                    {
                        $$ = svExprs();
                    }
                ;

// identifier

Id              :   IDENTIFIER
                    {
                        $$ = svId(new Id($1.strVal, $1.pos));
                    }
                ;
