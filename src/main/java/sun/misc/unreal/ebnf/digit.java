package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isDigit;

/**
 * Created by jim on 1/17/16.
 */
public class digit {
    public static final UnaryOperator<ByteBuffer> digit = b -> null != b && b.hasRemaining() && isDigit(b.get() & 0xff) ? b : null;
}
