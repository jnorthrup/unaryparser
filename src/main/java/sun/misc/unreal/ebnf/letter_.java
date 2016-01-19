package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isAlphabetic;

/**
 * Created by jim on 1/17/16.
 */
public enum letter_ {
    ;
    public static final UnaryOperator<ByteBuffer> letter = b -> null != b && b.hasRemaining() && isAlphabetic(b.get() & 0xff) ? b : null;
}
