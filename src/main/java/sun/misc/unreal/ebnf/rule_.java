package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;
import bbcursive.lib.allOf_;
import bbcursive.lib.confix_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.std.bb;

/**
 * Created by jim on 1/17/16.
 */
public enum rule_ {
    ;
    public static final UnaryOperator<ByteBuffer> rule = new ByteBufferUnaryOperator();
@Skipper@Backtracking
    private static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer, allOf_.allOf(lhs_.lhs, confix_.confix("=;", rhs_.rhs)));
        }
    }
}
