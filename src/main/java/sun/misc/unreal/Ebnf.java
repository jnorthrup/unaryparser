package sun.misc.unreal;

import bbcursive.lib.*;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;

import static bbcursive.Cursive.pre.toEol;
import static bbcursive.lib.chlit.*;


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


    UnaryOperator<ByteBuffer> letter= sun.misc.unreal.ebnf.letter.letter;
    UnaryOperator<ByteBuffer> symbol2 = anyOf.anyOf(chlit('['), chlit(']'), chlit('{'), chlit('}'), chlit('('), chlit(')'),
            chlit('<'), chlit('>'), chlit('\''), chlit('"'), chlit('='), chlit('|'), chlit('.'), chlit(','),
            chlit(';'));

    UnaryOperator<ByteBuffer> ebnfComments = confix.confix("()", confix.confix("*", sun.misc.unreal.ebnf.grammar.grammar));
    UnaryOperator<ByteBuffer> cComments = confix.confix("/", confix.confix("*", sun.misc.unreal.ebnf.grammar.grammar));
    UnaryOperator<ByteBuffer> cxxComments = allOf.allOf(strlit.strlit("//"), toEol);


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
