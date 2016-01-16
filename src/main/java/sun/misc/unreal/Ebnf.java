package sun.misc.unreal;

import bbcursive.Cursive;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.StreamSupport;

import static bbcursive.Cursive.post.reset;
import static bbcursive.Cursive.pre.mark;
import static bbcursive.Cursive.pre.noop;
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
 * symbol = "[" | "]" | "{" | "}" | "(" | ")" | "<" | ">"
 * | "'" | '"' | "=" | "|" | "." | "," | ";" ;
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
 * rule = lhs , "=" , rhs , ";" ;
 * grammar = { rule } ;
 *
 */
public interface Ebnf {

    UnaryOperator<ByteBuffer> letter = b -> {
        int c = 0;
        if (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return c > 0 ? bb(b) : null;
    };
    UnaryOperator<ByteBuffer> digit = b -> {
        int c = 0;
        if (b.hasRemaining() && isDigit(bb(b, mark).get() & 0xff)) c++;
        return c <= 0 ? null : bb(b);
    };
    UnaryOperator<ByteBuffer> word = ((ByteBuffer b) -> {
        int c = 0;
        while (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return c > 0 ? bb(b, b.hasRemaining() ? reset : noop) : null;
    });
    UnaryOperator<ByteBuffer> symbol = b -> tryAll(b, chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'), chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','), chlit(';'));

    @Nullable
    static ByteBuffer tryAll(ByteBuffer b, UnaryOperator<ByteBuffer>...cursives) {

        Arrays.stream(cursives).parallel().anyMatch(bb(it))

    }
    UnaryOperator<ByteBuffer>
            character = anyOf(letter, digit, symbol, chlit('_'));
    UnaryOperator<ByteBuffer>
            identifier = allOf(letter, opt(anyOf(letter, digit, chlit('_'))));

//     terminal = anyOf(allOf(chlit('\'') , character , repeat( character ) , "'" ),allOf( '"' , character , { character } , '"')) ;


    static UnaryOperator<ByteBuffer> chlit(char c) {
        return buf -> buf.hasRemaining() && c == (bb(buf, mark).get() & 0xff) ? buf : null;
    }
}
