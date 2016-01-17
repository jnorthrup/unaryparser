package sun.misc.unreal;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;

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
    UnaryOperator<ByteBuffer> letter = b -> null != b && b.hasRemaining() && isAlphabetic(b.get() & 0xff) ? b : null;
    UnaryOperator<ByteBuffer> digit = b -> null != b && b.hasRemaining() && isDigit(b.get() & 0xff) ? b : null;
    UnaryOperator<ByteBuffer> word = b -> {
        if (null == b) return null;
        boolean rem;
        while ((rem=b.hasRemaining() )&& isAlphabetic(((ByteBuffer) b.mark()).get() & 0xff)) ;
        if(rem) {
            b.reset();
        }
        return b;
    };
    UnaryOperator<ByteBuffer> symbol = anyOf("[]{}()<>'\"=|.,;");
    UnaryOperator<ByteBuffer> symbol2 = anyOf(chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'),
            chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','),
            chlit(';'));
    UnaryOperator<ByteBuffer> character = anyOf(letter, digit, symbol, chlit('_'));
    UnaryOperator<ByteBuffer> identifier = allOf(letter, opt(anyOf(letter, digit, chlit('_'))));
    UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), character, repeat(character), anyOf(chlit('\''),
            chlit('"')), character, repeat(character), chlit('"'));
    UnaryOperator<ByteBuffer> lhs = identifier;
    UnaryOperator<ByteBuffer> optional = confix("[]", Ebnf.rhs);
    UnaryOperator<ByteBuffer> repeating = confix("{}", Ebnf.rhs);
    UnaryOperator<ByteBuffer> grouping = confix('(', Ebnf.rhs, ')');
    UnaryOperator<ByteBuffer> firstOf = allOf(Ebnf.rhs, chlit("|"), Ebnf.rhs);
    UnaryOperator<ByteBuffer> listOf = allOf(Ebnf.rhs, chlit(','), Ebnf.rhs);
    UnaryOperator<ByteBuffer> rule = buffer -> bb(buffer, allOf(lhs, confix("=;", Ebnf.rhs)));
    UnaryOperator<ByteBuffer> rhs = anyOf(identifier, terminal, optional, repeating, grouping, firstOf, listOf);
    UnaryOperator<ByteBuffer> grammar = repeat(rule);

    UnaryOperator<ByteBuffer> ebnfComments = confix("()", confix("*", grammar));
    UnaryOperator<ByteBuffer> cComments = confix("/", confix("*", grammar));
    UnaryOperator<ByteBuffer> cxxComments = allOf(strlit("//"), toEol);


    enum Lookup {;
        static Map<UnaryOperator, String> x = new LinkedHashMap<>();

          static String apply(UnaryOperator<ByteBuffer> op) {
            String s = x.
                    computeIfAbsent(op, unaryOperator -> {
                        Field[] declaredFields = Ebnf.class.getDeclaredFields();
                        for (Field declaredField : declaredFields)
                            try {
                                if (Objects.equals(op, declaredField.get(null))) return declaredField.getName();
                            } catch (IllegalAccessException e) {
                            }
                        return op.toString();
                    });
            return s;
        }
    }
}
