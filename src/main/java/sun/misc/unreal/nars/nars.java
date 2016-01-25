package sun.misc.unreal.nars;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.confix_.confix;
import static bbcursive.lib.infix_.infix;
import static bbcursive.lib.opt_.opt;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.lib.skipper_.skipper;
import static bbcursive.lib.strlit.strlit;
import static sun.misc.unreal.ebnf.word_.word;

/**
 * Created by jim on 1/20/16.
 */
public interface nars {
    ;

    /* sentence type and delimitors */
    /* variable type */
    UnaryOperator<ByteBuffer> JUDGMENT_MARK = chlit('.');
    UnaryOperator<ByteBuffer> QUESTION_MARK = chlit('?');
    UnaryOperator<ByteBuffer> GOAL_MARK = chlit('!');
    UnaryOperator<ByteBuffer> QUEST_MARK = chlit('@');
    UnaryOperator<ByteBuffer> VAR_INDEPENDENT = chlit('$');
    UnaryOperator<ByteBuffer> VAR_DEPENDENT = chlit('#');
    UnaryOperator<ByteBuffer> VAR_QUERY = chlit('?');

    /* numerical chlit(value delimitors, must be different from the Term delimitors *)/
   UnaryOperator<ByteBuffer> BUDGET_VALUE_MARK = chlit('$');
   UnaryOperator<ByteBuffer> TRUTH_VALUE_MARK = chlit('%');
   UnaryOperator<ByteBuffer> VALUE_SEPARATOR = chlit(';');

   /* CompountTerm chlit(delimitors, must use 4 different pairs *)/
   UnaryOperator<ByteBuffer> COMPOUND_TERM_OPENER = chlit('(');
   UnaryOperator<ByteBuffer> COMPOUND_TERM_CLOSER = chlit(')');
   UnaryOperator<ByteBuffer> STATEMENT_OPENER = chlit('<');
   UnaryOperator<ByteBuffer> STATEMENT_CLOSER = chlit('>');
   UnaryOperator<ByteBuffer> SET_EXT_OPENER = chlit('{');
   UnaryOperator<ByteBuffer> SET_EXT_CLOSER = chlit('}');
   UnaryOperator<ByteBuffer> SET_INT_OPENER = chlit('[');
   UnaryOperator<ByteBuffer> SET_INT_CLOSER = chlit(']');

                                                   /* special chlit(characors in argument list *)/
   UnaryOperator<ByteBuffer> ARGUMENT_SEPARATOR = chlit(',');
   UnaryOperator<ByteBuffer> IMAGE_PLACE_HOLDER = chlit('_');

     /* Tense markers */
    UnaryOperator<ByteBuffer> TENSE_MARK = strlit(":");
    UnaryOperator<ByteBuffer> TENSE_PAST = strlit(":\\:");
    UnaryOperator<ByteBuffer> TENSE_PRESENT = strlit(":|:");
    UnaryOperator<ByteBuffer> TENSE_FUTURE = strlit(":/:");
    UnaryOperator<ByteBuffer> TERMLISTTAIL = skipper(repeat(chlit(','), term()));


    enum Operator implements UnaryOperator<ByteBuffer> {
        /* CompountTerm operators, length = 1 */
        INTERSECTION_EXT {
            @Override
            public String toString() {
                return "&";
            }
        },
        INTERSECTION_INT {
            @Override
            public String toString() {
                return "|";
            }
        },
        DIFFERENCE_EXT {
            @Override
            public String toString() {
                return "-";
            }
        },
        DIFFERENCE_INT {
            @Override
            public String toString() {
                return "~";
            }
        },
        PRODUCT {
            @Override
            public String toString() {
                return "*";
            }
        },
        IMAGE_EXT {
            @Override
            public String toString() {
                return "/";
            }
        },
        IMAGE_INT {
            @Override
            public String toString() {
                return "\\";
            }
        },

        /* CompoundStatement operators, length = 2 */
        NEGATION {
            @Override
            public String toString() {
                return "--";
            }
        },
        DISJUNCTION {
            @Override
            public String toString() {
                return "||";
            }
        },
        CONJUNCTION {
            @Override
            public String toString() {
                return "&&";
            }
        },
        SEQUENCE {
            @Override
            public String toString() {
                return "&/";
            }
        },
        PARALLEL {
            @Override
            public String toString() {
                return "&|";
            }
        };


        public ByteBuffer apply(ByteBuffer o) {
            return strlit(toString()).apply(o);
        }
    }

    UnaryOperator<ByteBuffer> INTERSECTION_EXT_OPERATORc = chlit('&');
    UnaryOperator<ByteBuffer> DIFFERENCE_EXT_OPERATORc = chlit('-');
    UnaryOperator<ByteBuffer> DIFFERENCE_INT_OPERATORc = chlit('~');
    UnaryOperator<ByteBuffer> PRODUCT_OPERATORc = chlit('*');
    UnaryOperator<ByteBuffer> INTERSECTION_INT_OPERATORc = chlit('|');
    UnaryOperator<ByteBuffer> IMAGE_EXT_OPERATORc = chlit('/');
    UnaryOperator<ByteBuffer> IMAGE_INT_OPERATORc = chlit('\\');
    UnaryOperator<ByteBuffer> NEGATION_OPERATORc = chlit('-');
    UnaryOperator<ByteBuffer> DISJUNCTION_OPERATORc = chlit('|');
    UnaryOperator<ByteBuffer> CONJUNCTION_OPERATORc = chlit('&');
    UnaryOperator<ByteBuffer> INTERSECTION_EXT_OPERATOR = strlit("&");
    UnaryOperator<ByteBuffer> INTERSECTION_INT_OPERATOR = strlit("|");
    UnaryOperator<ByteBuffer> DIFFERENCE_EXT_OPERATOR = strlit("-");
    UnaryOperator<ByteBuffer> DIFFERENCE_INT_OPERATOR = strlit("~");
    UnaryOperator<ByteBuffer> PRODUCT_OPERATOR = strlit("*");
    UnaryOperator<ByteBuffer> IMAGE_EXT_OPERATOR = strlit("/");
    UnaryOperator<ByteBuffer> IMAGE_INT_OPERATOR = strlit("\\");
    UnaryOperator<ByteBuffer> NEGATION_OPERATOR = strlit("--");
    UnaryOperator<ByteBuffer> DISJUNCTION_OPERATOR = strlit("||");
    UnaryOperator<ByteBuffer> CONJUNCTION_OPERATOR = strlit("&&");
    UnaryOperator<ByteBuffer> SEQUENCE_OPERATOR = strlit("&/");
    UnaryOperator<ByteBuffer> PARALLEL_OPERATOR = strlit("&|");

    enum Relation implements UnaryOperator {
        INHERITANCE {
            @Override
            public String toString() {
                return "-->";
            }
        },
        SIMILARITY {
            @Override
            public String toString() {
                return "<->";
            }
        },
        INSTANCE {
            @Override
            public String toString() {
                return "{--";
            }
        },
        PROPERTY {
            @Override
            public String toString() {
                return "--]";
            }
        },
        INSTANCE_PROPERTY {
            @Override
            public String toString() {
                return "{-]";
            }
        },
        IMPLICATION {
            @Override
            public String toString() {
                return "==>";
            }
        },
        IMPLICATION_AFTER {
            @Override
            public String toString() {
                return "=/>";
            }
        },
        IMPLICATION_WHEN {
            @Override
            public String toString() {
                return "=|>";
            }
        },
        IMPLICATION_BEFORE {
            @Override
            public String toString() {
                return "=\\>";
            }
        },
        EQUIVALENCE {
            @Override
            public String toString() {
                return "<=>";
            }
        },
        EQUIVALENCE_AFTER {
            @Override
            public String toString() {
                return "</>";
            }
        },
        EQUIVALENCE_WHEN {
            @Override
            public String toString() {
                return "<|>";
            }
        };

        @Override
        public ByteBuffer apply(Object o) {
            return strlit(this.toString()).apply((ByteBuffer) o);
        }
    }

    static UnaryOperator<ByteBuffer> copula() {
        return anyOf(Relation.values());
    }

    UnaryOperator<ByteBuffer> negation = confix(strlit("(--"), chlit(')'), term());
    UnaryOperator<ByteBuffer> extensionaldifference = confix(strlit("(-"), chlit(')'), confix(term(), term(), chlit(',')));
    UnaryOperator<ByteBuffer> intensionaldifference = confix(strlit("(~"), chlit(')'), confix(term(), term(), chlit(',')));
    UnaryOperator<ByteBuffer> intensionalset = confix("[]", allOf(term(), opt(TERMLISTTAIL)));
    UnaryOperator<ByteBuffer> extensionalset = confix("{}", TERMLISTTAIL);
    UnaryOperator<ByteBuffer> intensionalintersection = confix(strlit("(|"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> extensionalintersection = confix(strlit("(&"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> product = confix(strlit("(*"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> extensionalimage = confix(strlit("(/"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> intensionalimage = confix(strlit("(\\"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> disjunction = confix(strlit("(||"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> conjunction = confix(strlit("(&&"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> sequentialevents = confix(strlit("(&/"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> parallelevents = confix(strlit("(&|"), chlit(")"), TERMLISTTAIL);
    UnaryOperator<ByteBuffer> statement = anyOf(confix("<>", skipper(term(), copula(), term())), allOf(strlit("@$|!LexMe!|$@"), term()), confix(strlit("(^"), chlit(")"), allOf(word, TERMLISTTAIL))),
            variable = infix(anyOf("#?$"), word),
            tense = anyOf(TENSE_FUTURE, TENSE_PAST, TENSE_PRESENT),
            val = infix(allOf(opt(anyOf("10")), anyOf(".10"), repeat(anyOf("1092387456")))),
            frequency = val,
            confidence = val, priority = val, durability = val,

    truth = confix("%", skipper(frequency, opt(chlit(';'),confidence))),
    budget = confix("$", skipper(priority, opt(chlit(';'),durability))),
    compoundTerm=anyOf(
            negation,
            extensionaldifference,
            intensionaldifference,
            intensionalset,
            extensionalset,
            intensionalintersection,
            extensionalintersection,
            product,
            extensionalimage,
            intensionalimage,
            disjunction,
            conjunction,
            sequentialevents,
            parallelevents);


    static UnaryOperator<ByteBuffer> term() {

        return anyOf(word,
                variable,
                compoundTerm, statement);

    }


    UnaryOperator<ByteBuffer> JavIdent = new UnaryOperator<ByteBuffer>() {
        @Override
        public String toString() {
            return "identifier";
        }

        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return (ByteBuffer) repeat(buffer1 -> buffer1.hasRemaining() && Character.isJavaIdentifierPart(buffer1.get()) ? buffer1 : null);
        }
    };

}
