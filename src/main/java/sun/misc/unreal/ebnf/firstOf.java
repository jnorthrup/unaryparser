package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.chlit;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class firstOf {
    public static final UnaryOperator<ByteBuffer> firstOf = allOf.allOf(rhs.rhs, chlit.chlit("|"), rhs.rhs);
}
