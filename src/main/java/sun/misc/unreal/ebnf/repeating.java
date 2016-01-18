package sun.misc.unreal.ebnf;

import bbcursive.lib.confix;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class repeating {
    public static final UnaryOperator<ByteBuffer> repeating = confix.confix("{}", rhs.rhs);
}
