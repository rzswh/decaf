package decaf.frontend.parsing;

import decaf.driver.Config;
import decaf.driver.Phase;
import decaf.frontend.tree.Tree;
import decaf.lowlevel.log.IndentPrinter;
import decaf.printing.PrettyTree;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * The alternative parser phase.
 */
public class LLParser extends Phase<InputStream, Tree.TopLevel> {

    public LLParser(Config config) {
        super("parser-ll", config);
    }

    @Override
    public Tree.TopLevel transform(InputStream input) {
        var lexer = new decaf.frontend.parsing.DecafLexer<Parser>(new InputStreamReader(input));
        var parser = new Parser();
        lexer.setup(parser, this);
        parser.setup(lexer, this);
        parser.parse();
        return parser.tree;
    }

    @Override
    public void onSucceed(Tree.TopLevel tree) {
        if (config.target.equals(Config.Target.PA1_LL)) {
            var printer = new PrettyTree(new IndentPrinter(config.output));
            printer.pretty(tree);
            printer.flush();
        }
    }

    private class Parser extends decaf.frontend.parsing.LLTable {
        @Override
        boolean parse() {
            var sv = parseSymbol(start, new TreeSet<>());
            if (sv == null) {
                return false;
            }
            return true;
        }

        @Override
        public int tokenOf(int code) {
            return switch (code) {
                case Tokens.VOID -> VOID;
                case Tokens.BOOL -> BOOL;
                case Tokens.INT -> INT;
                case Tokens.STRING -> STRING;
                case Tokens.CLASS -> CLASS;
                case Tokens.NULL -> NULL;
                case Tokens.EXTENDS -> EXTENDS;
                case Tokens.THIS -> THIS;
                case Tokens.WHILE -> WHILE;
                case Tokens.FOR -> FOR;
                case Tokens.IF -> IF;
                case Tokens.ELSE -> ELSE;
                case Tokens.RETURN -> RETURN;
                case Tokens.BREAK -> BREAK;
                case Tokens.NEW -> NEW;
                case Tokens.PRINT -> PRINT;
                case Tokens.READ_INTEGER -> READ_INTEGER;
                case Tokens.READ_LINE -> READ_LINE;
                case Tokens.BOOL_LIT -> BOOL_LIT;
                case Tokens.INT_LIT -> INT_LIT;
                case Tokens.STRING_LIT -> STRING_LIT;
                case Tokens.ABSTRACT -> ABSTRACT;
                case Tokens.IDENTIFIER -> IDENTIFIER;
                case Tokens.AND -> AND;
                case Tokens.OR -> OR;
                case Tokens.STATIC -> STATIC;
                case Tokens.INSTANCE_OF -> INSTANCE_OF;
                case Tokens.LESS_EQUAL -> LESS_EQUAL;
                case Tokens.GREATER_EQUAL -> GREATER_EQUAL;
                case Tokens.EQUAL -> EQUAL;
                case Tokens.NOT_EQUAL -> NOT_EQUAL;
                case Tokens.DOUBLE_ARROW -> DOUBLE_ARROW;
                case Tokens.FUN -> FUN;
                case Tokens.VAR -> VAR;
                default -> code; // single-character, use their ASCII code!
            };
        }

        /**
         * Parse function for every non-terminal, with error recovery.
         * NOTE: the current implementation is buggy and may throw {@link NullPointerException}.
         * TODO: find a correct implementation for error recovery!
         * TODO: You are free to change the method body as you wish, but not the interface!
         *
         * @param symbol the non-terminal to be parsed
         * @return the parsed value of {@code symbol} if parsing succeeds, or else {@code null}.
         */
        private SemValue parseSymbol(int symbol, Set<Integer> follow) {
            TreeSet<Integer> end = new TreeSet<>(follow);
            end.addAll(followSet(symbol));   // modified!
            var result = query(symbol, token); // get production by lookahead symbol
            while (true) {
                if (result != null) {           // correct syntax
                    var actionId = result.getKey(); // get user-defined action

                    var right = result.getValue(); // right-hand side of production
                    var length = right.size();
                    var params = new SemValue[length + 1];
                    boolean succ = true;

                    for (var i = 0; i < length; i++) { // parse right-hand side symbols one by one
                        var term = right.get(i);
                        params[i + 1] = isNonTerminal(term)
                                ? parseSymbol(term, end) // for non terminals: recursively parse it
                                : matchToken(term) // for terminals: match token
                        ;
                        if (params[i+1] == null)
                            succ = false;
                    }

                    if (succ)
                        act(actionId, params); // do user-defined action
                    else
                        params[0] = null;   // expression parsing error
                    return params[0];
                } else // error revocery
                {
                    // print error info
                    yyerror("syntax error");

                    while (query(symbol, token) == null && !end.contains(token)) {
                        nextToken();
                    }
                    result = query(symbol, token);
                    if (result == null) {
                        // terminate analysis of SYMBOL
                        return null;
                    }
                }
            }
        }

        /**
         * Match if the lookahead token is the same as the expected token.
         *
         * @param expected the expected token.
         * @return sem value
         */
        private SemValue matchToken(int expected) {
            SemValue self = semValue;
            if (token != expected) {
                yyerror("syntax error");
                return null;
            }

            token = nextToken();
            return self;
        }
    }
}