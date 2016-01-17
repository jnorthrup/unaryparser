package sun.misc.unreal;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.Cursive.post.reset;
import static bbcursive.Cursive.pre.mark;
import static bbcursive.Cursive.pre.noop;
import static bbcursive.Cursive.pre.toEol;
import static bbcursive.std.*;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;


/**
 * letter = "A" | "B" | "C" | "D" | "E" | "F" | "G"
 * | "H" | "I" | "J" | "K" | "L" | "M" | "N"
 * | "O" | "P" | "Q" | "R" | "S" | "T" | "U"
 * | "V" | "W" | "X" | "Y" | "Z" | "a" | "b"
 * | "c" | "d" | "e" | "f" | "g" | "h" | "i"
 * | "j" | "k" | "l" | "m" | "n" | "o" | "p"
 * | "q" | "r" | "s" | "t" | "u" | "v" | "w"
 * | "x" | "y" | "z" ;
 * digit = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
 * symbol = "[" | "]" | "{" | "}" | "(" | ")" | "<" | ">" | "'" | '"' | "=" | "|" | "." | "," | ";" ;
 * character = letter | digit | symbol | "_" ;
 * <p>
 * identifier = letter , { letter | digit | "_" } ;
 * terminal = "'" , character , { character } , "'" | '"' , character , { character } , '"' ;
 * <p>
 * lhs = identifier ;
 * rhs = identifier
 * | terminal
 * | "[" , rhs , "]"
 * | "{" , rhs , "}"
 * | "(" , rhs , ")"
 * | rhs , "|" , rhs
 * | rhs , "," , rhs ;
 * <p>
 * <p>
 * rule = lhs , "=" , rhs , ";" ;
 * grammar = { rule } ;
 */
public interface Ebnf {


    UnaryOperator<ByteBuffer> letter = b -> {
        int c = 0;
        if (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return 0 < c ? bb(b) : null;
    };
    UnaryOperator<ByteBuffer> digit = b -> {
        int c = 0;
        if (b.hasRemaining() && isDigit(bb(b, mark).get() & 0xff)) c++;
        return 0 >= c ? null : bb(b);
    };
    UnaryOperator<ByteBuffer> word = b -> {
        int c = 0;
        while (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return 0 < c ? bb(b, b.hasRemaining() ? reset : noop) : null;
    };
    UnaryOperator<ByteBuffer> symbol  = anyOf("[]{}()<>'\"=|.,;");
    UnaryOperator<ByteBuffer> symbol2 = anyOf(chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'), chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','), chlit(';'));
    UnaryOperator<ByteBuffer> character = anyOf(Ebnf.letter, Ebnf.digit, Ebnf.symbol, chlit('_'));
    UnaryOperator<ByteBuffer> identifier = allOf(Ebnf.letter, opt(anyOf(Ebnf.letter, Ebnf.digit, chlit('_'))));
    UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), Ebnf.character, repeat(Ebnf.character), anyOf(chlit('\''), chlit('"')), Ebnf.character, repeat(Ebnf.character), chlit('"'));
    UnaryOperator<ByteBuffer> lhs = Ebnf.identifier;
    UnaryOperator<ByteBuffer> optional = confix("[]", Ebnf.rhs);
    UnaryOperator<ByteBuffer> repeating = confix("{}", Ebnf.rhs);
    UnaryOperator<ByteBuffer> grouping = confix('(', Ebnf.rhs, ')');
    UnaryOperator<ByteBuffer> firstOf = allOf(Ebnf.rhs, chlit("|"), Ebnf.rhs);
    UnaryOperator<ByteBuffer> listOf = allOf(Ebnf.rhs, chlit(','), Ebnf.rhs);
    UnaryOperator<ByteBuffer> rule = allOf(Ebnf.lhs, confix("=;", Ebnf.rhs));
    UnaryOperator<ByteBuffer> rhs = anyOf(Ebnf.identifier, Ebnf.terminal, Ebnf.optional, Ebnf.repeating, Ebnf.grouping, Ebnf.firstOf, Ebnf.listOf);
    UnaryOperator<ByteBuffer> grammar = repeat(Ebnf.rule);

    UnaryOperator<ByteBuffer> comments= confix("()",confix("*",grammar));
    UnaryOperator<ByteBuffer> c_comments= confix("/",confix("*",grammar));
    UnaryOperator<ByteBuffer> cxx_comments= allOf(strlit("//"),toEol);


    enum published {
        letter,
        digit,
        word,
//        symbol2,
        symbol,
        character,
        identifier,
        terminal,
        lhs,
        optional,
        repeating,
        grouping,
        firstOf,
        listOf,
        rule,
        rhs,
        grammar;

        private final Method method;

        published(){
            try {
                method = Ebnf.class.getMethod(name());
            } catch (NoSuchMethodException e) {
                throw new Error("rebind somethig");
            }
        }
    }
}