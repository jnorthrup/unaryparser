package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Infix;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isAlphabetic;

/**
 * Created by jim on 1/17/16.
 */
public enum word_ {
    ;
    public static final UnaryOperator<ByteBuffer> word = new ByteBufferUnaryOperator();

    @Infix@Backtracking
     static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public ByteBuffer apply(ByteBuffer b) {
            if (null != b) {
                boolean rem;
                while ((rem = b.hasRemaining()) && isAlphabetic(((ByteBuffer) b.mark()).get() & 0xff)) ;
                if (rem) {
                    b.reset();
                }
                return b;
            }
            return null;
        }
    }
}
