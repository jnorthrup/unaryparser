package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.identifier_.identifier;

/**
 * Created by jim on 1/17/16.
 */
public enum lhs_ {
    ;
    public static final UnaryOperator<ByteBuffer> lhs = new UnaryOperator<ByteBuffer>() {
        @Override
        public String toString() {
            return "lhs";
        }

        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer, identifier());
        }
    };
}
