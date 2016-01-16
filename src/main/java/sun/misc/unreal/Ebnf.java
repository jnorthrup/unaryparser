package sun.misc.unreal;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

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
 *
 * rule = lhs , "=" , rhs , ";" ;
 * grammar = { rule } ;
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
    UnaryOperator<ByteBuffer> word = b -> {
        int c = 0;
        while (b.hasRemaining() && isAlphabetic(bb(b, mark).get() & 0xff)) c++;
        return c > 0 ? bb(b, b.hasRemaining() ? reset : noop) : null;
    };
    UnaryOperator<ByteBuffer> symbol = allOf(chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'),
            chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','),
            chlit(';'));
    UnaryOperator<ByteBuffer>
            character = anyOf(letter, digit, symbol, chlit('_'));
    UnaryOperator<ByteBuffer> identifier = allOf(letter, opt(anyOf(letter, digit, chlit('_'))));
    UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), character, repeat(character), anyOf(chlit('\'') , chlit('"')), character, repeat(character), chlit('"'));
    UnaryOperator<ByteBuffer> lhs= identifier;
    UnaryOperator<ByteBuffer> rhs=anyOf(identifier, terminal, Ebnf.optional, Ebnf.repeating, Ebnf.grouping, Ebnf.firstOf, Ebnf.listOf);
    UnaryOperator<ByteBuffer> optional= confix("[]", rhs);
    UnaryOperator<ByteBuffer> repeating= confix("{}", rhs);
    UnaryOperator<ByteBuffer> grouping = confix('(', rhs,')' );
    UnaryOperator<ByteBuffer> firstOf=allOf(rhs,chlit("|") , rhs);
    UnaryOperator<ByteBuffer> listOf =allOf(rhs, chlit(','), rhs);
    UnaryOperator<ByteBuffer> rule = allOf(lhs, chlit("=") , rhs, chlit(";" ));
    UnaryOperator<ByteBuffer> grammar=repeat(rule);

//     terminal = anyOf(allOf(chlit('\'') , character, repeat(character) , "'" ),allOf( '"' , character, {character} , '"')) ;


}