package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.anyOf_.*;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.firstOf_.firstOf;
import static sun.misc.unreal.ebnf.grouping_.grouping;
import static sun.misc.unreal.ebnf.identifier_.identifier;
import static sun.misc.unreal.ebnf.listOf_.listOf;
import static sun.misc.unreal.ebnf.optional_.optional;
import static sun.misc.unreal.ebnf.repeating_.repeating;
import static sun.misc.unreal.ebnf.terminal_.terminal;

/**
 * Created by jim on 1/17/16.
 */
public enum rhs_ {
    ;

    public static final UnaryOperator<ByteBuffer> rhs() {
        return new UnaryOperator<ByteBuffer>() {
            @Override
            public String toString() {
                return "rhs";
            }

            @Override
            public ByteBuffer apply(ByteBuffer buffer) {
                return bb(buffer, anyIn(identifier(), terminal(), optional, repeating(), grouping, firstOf, listOf));
            }
        };
    }
}
