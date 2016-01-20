package sun.misc.unreal.ebnf;

import bbcursive.lib.chlit_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static sun.misc.unreal.ebnf.rhs_.rhs;

/**
 * Created by jim on 1/17/16.
 */
public enum listOf_ {
    ;
    public static final UnaryOperator<ByteBuffer> listOf = allOf(rhs(), chlit_.chlit(','), rhs());
}
