package sun.misc.unreal.ebnf;

import bbcursive.ann.Infix;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isAlphabetic;

/**
 * Created by jim on 1/17/16.
 */
public enum letter_ {
    ;
    public static final UnaryOperator<ByteBuffer> letter = new ByteBufferUnaryOperator();
    @Infix
    private static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public String toString() {
            return "e:letter" ;
        }

        @Override
        public ByteBuffer apply(ByteBuffer b) {
            return null != b && b.hasRemaining() && isAlphabetic(b.get() & 0xff) ? b : null;
        }
    }
}
