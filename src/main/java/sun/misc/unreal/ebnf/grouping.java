package sun.misc.unreal.ebnf;

import bbcursive.lib.confix;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum grouping {
    ;
    public static final UnaryOperator<ByteBuffer> grouping = confix.confix('(', rhs.rhs, ')');
}
