package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.confix_.confix;
import static sun.misc.unreal.ebnf.rhs_.*;

/**
 * Created by jim on 1/17/16.
 */
public enum grouping_ {
    ;
    public static final UnaryOperator<ByteBuffer> grouping = confix('(', rhs(), ')');
}
