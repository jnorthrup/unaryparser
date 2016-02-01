package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum symbol_ {
    ;
    public static final UnaryOperator<ByteBuffer> symbol = anyOf_.anyIn("[]{}()<>'\"=|.,;");
}
