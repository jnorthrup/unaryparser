package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class lhs {
    public static final UnaryOperator<ByteBuffer> lhs = identifier.identifier;
}
