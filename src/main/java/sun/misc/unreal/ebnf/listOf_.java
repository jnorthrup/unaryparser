package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.chlit_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum listOf_ {
    ;
    public static final UnaryOperator<ByteBuffer> listOf = allOf.allOf(rhs_.rhs, chlit_.chlit(','), rhs_.rhs);
}
