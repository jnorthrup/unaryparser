package sun.misc.unreal;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

import static bbcursive.Cursive.post.reset;
import static bbcursive.Cursive.pre.*;
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
        return 0 >= c ? null : bb(b);
    };
    UnaryOperator<ByteBuffer> digit = b -> {
        int c = 0;
        return !b.hasRemaining() || !isDigit(bb(b, mark).get() & 0xff) ? 0 >= c ? null : bb(b) : 0 >= ++c ? null : bb(b);
    };
    UnaryOperator<ByteBuffer> word = b -> {
        int c = 0;
        while (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return 0 < c ? bb(b, b.hasRemaining() ? reset : noop) : null;
    };
    UnaryOperator<ByteBuffer> symbol  = anyOf("[]{}()<>'\"=|.,;");
    UnaryOperator<ByteBuffer> symbol2 = anyOf(chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'), chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','), chlit(';'));
    UnaryOperator<ByteBuffer> character = anyOf(letter, digit, symbol, chlit('_'));
    UnaryOperator<ByteBuffer> identifier = allOf(letter, opt(anyOf(letter, digit, chlit('_'))));
    UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), character, repeat(character), anyOf(chlit('\''), chlit('"')), character, repeat(character), chlit('"'));
    UnaryOperator<ByteBuffer> lhs = identifier;
    UnaryOperator<ByteBuffer> optional = confix("[]", Ebnf.rhs);
    UnaryOperator<ByteBuffer> repeating = confix("{}", Ebnf.rhs);
    UnaryOperator<ByteBuffer> grouping = confix('(', Ebnf.rhs, ')');
    UnaryOperator<ByteBuffer> firstOf = allOf(Ebnf.rhs, chlit("|"), Ebnf.rhs);
    UnaryOperator<ByteBuffer> listOf = allOf(Ebnf.rhs, chlit(','), Ebnf.rhs);
    UnaryOperator<ByteBuffer> rule = allOf(lhs, confix("=;", Ebnf.rhs));
    UnaryOperator<ByteBuffer> rhs = anyOf(identifier, terminal, optional, repeating, grouping, firstOf, listOf);
    UnaryOperator<ByteBuffer> grammar = repeat(rule);

    UnaryOperator<ByteBuffer> comments= confix("()",confix("*", Ebnf.grammar));
    UnaryOperator<ByteBuffer> c_comments= confix("/",confix("*", Ebnf.grammar));
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


        private UnaryOperator lambda;

        published(){
            try {
                Object o = Ebnf.class.getField(this.name()).get(null);
                if (o instanceof UnaryOperator) {
                    lambda = (UnaryOperator) o;
                    registry.put(lambda, this);
                }

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    Map<UnaryOperator,published> registry = new LinkedHashMap< >();
}