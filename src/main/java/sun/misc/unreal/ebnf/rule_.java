package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static bbcursive.lib.confix_.confix;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.lhs_.lhs;
import static sun.misc.unreal.ebnf.rhs_.rhs;

/**
 * Created by jim on 1/17/16.
 */
public enum rule_ {
    ;
    public static final UnaryOperator<ByteBuffer> rule = new ByteBufferUnaryOperator();
    @Skipper@Backtracking
    private static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {

    private UnaryOperator<ByteBuffer> byteBufferUnaryOperator = allOf(lhs, confix("=;", rhs()));

    @Override
    public String toString() {
        return "rule:"+byteBufferUnaryOperator;
    }

    @Override
        public ByteBuffer apply(ByteBuffer buffer) {
        return bb(buffer, byteBufferUnaryOperator);
        }
    }
}
