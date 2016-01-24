package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isDigit;

/**
 * Created by jim on 1/17/16.
 */
public enum digit_ {
    ;
    public static final UnaryOperator<ByteBuffer> digit = new UnaryOperator<ByteBuffer>() {
        @Override
        public String toString() {
            return "digit";
        }

        @Override
        public ByteBuffer apply(ByteBuffer b) {
            return null != b && b.hasRemaining() && isDigit(b.get() & 0xff) ? b : null;
        }
    };
}
