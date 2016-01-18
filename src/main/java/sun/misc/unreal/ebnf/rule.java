package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.confix;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.std.bb;

/**
 * Created by jim on 1/17/16.
 */
public class rule {
    public static final UnaryOperator<ByteBuffer> rule = buffer -> bb(buffer, allOf.allOf(lhs.lhs, confix.confix("=;", rhs.rhs)));
}
