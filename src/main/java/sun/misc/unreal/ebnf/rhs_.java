package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.firstOf_.firstOf;
import static sun.misc.unreal.ebnf.grouping_.grouping;
import static sun.misc.unreal.ebnf.listOf_.listOf;
import static sun.misc.unreal.ebnf.optional_.optional;
import static sun.misc.unreal.ebnf.repeating_.repeating;

/**
 * Created by jim on 1/17/16.
 */
public enum rhs_ {
    ;

    public static final UnaryOperator<ByteBuffer> rhs() {
        return new ByteBufferUnaryOperator();
    }

    ;

    @Skipper
    @Backtracking
    static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer, anyOf(identifier_.identifier, terminal_.terminal(), optional, repeating, grouping, firstOf, listOf));
        }
    }
}
