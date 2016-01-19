package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.confix_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.std.bb;

/**
 * Created by jim on 1/17/16.
 */
public enum rule_ {
    ;
    public static final UnaryOperator<ByteBuffer> rule = buffer -> bb(buffer, allOf.allOf(lhs_.lhs, confix_.confix("=;", rhs_.rhs)));
}
