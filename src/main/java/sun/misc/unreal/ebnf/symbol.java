package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class symbol {
    public static final UnaryOperator<ByteBuffer> symbol = anyOf.anyOf("[]{}()<>'\"=|.,;");
}
