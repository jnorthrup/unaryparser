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
            character = anyOf(Ebnf.letter, Ebnf.digit, Ebnf.symbol, chlit('_'));
    UnaryOperator<ByteBuffer> identifier = allOf(Ebnf.letter, opt(anyOf(Ebnf.letter, Ebnf.digit, chlit('_'))));
    UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), Ebnf.character, repeat(Ebnf.character), anyOf(chlit('\'') , chlit('"')), Ebnf.character, repeat(Ebnf.character), chlit('"'));
    UnaryOperator<ByteBuffer> lhs= Ebnf.identifier;
    UnaryOperator<ByteBuffer> rhs=anyOf(Ebnf.identifier, Ebnf.terminal, Ebnf.optional, Ebnf.repeating, Ebnf.grouping, Ebnf.firstOf, Ebnf.listOf);
    UnaryOperator<ByteBuffer> optional=allOf(chlit("[" ), Ebnf.rhs,chlit( "]"));
    UnaryOperator<ByteBuffer> repeating=allOf(chlit("{"), Ebnf.rhs, chlit("}"));
    UnaryOperator<ByteBuffer> grouping =allOf(chlit("("), Ebnf.rhs,chlit( ")"));
    UnaryOperator<ByteBuffer> firstOf=allOf(Ebnf.rhs,chlit("|") , Ebnf.rhs);
    UnaryOperator<ByteBuffer> listOf =allOf(Ebnf.rhs, chlit(','), Ebnf.rhs);
    UnaryOperator<ByteBuffer> rule = allOf(lhs , chlit("=") , rhs , chlit(";" ));
    UnaryOperator<ByteBuffer> grammar=repeat(Ebnf.rule);
            ;

//     terminal = anyOf(allOf(chlit('\'') , character, repeat(character) , "'" ),allOf( '"' , character, {character} , '"')) ;


}