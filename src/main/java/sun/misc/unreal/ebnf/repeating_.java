package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.confix_.confix;

/**
 * Created by jim on 1/17/16.
 */
public enum repeating_ {
    ;
    public static final UnaryOperator<ByteBuffer> repeating (){     return confix("{}", rhs_.rhs());};


}
