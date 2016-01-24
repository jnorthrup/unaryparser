package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.confix_.confix;
import static bbcursive.lib.infix_.infix;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.character_.character;

/**
 * Created by jim on 1/17/16.
 */
public enum terminal_ {
    ;

    public static final UnaryOperator<ByteBuffer> terminal() {
        return new ByteBufferUnaryOperator();
    }
    @Skipper
    @Backtracking
      static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public String toString() {
            return "terminal";
        }

        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer, anyOf(
                    confix("''", infix(allOf(character, repeat(character)))),
                    confix("\"\"", infix(allOf(character, repeat(character))))));

        }
    }



}
