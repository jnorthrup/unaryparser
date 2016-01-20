package sun.misc.unreal.ebnf;

import bbcursive.lib.confix_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum repeating_ {
    ;
    public static final UnaryOperator<ByteBuffer> repeating = confix_.confix("{}", rhs_.rhs());
}
