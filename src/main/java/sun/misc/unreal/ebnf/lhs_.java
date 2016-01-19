package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum lhs_ {
    ;
    public static final UnaryOperator<ByteBuffer> lhs = identifier_.identifier;
}
