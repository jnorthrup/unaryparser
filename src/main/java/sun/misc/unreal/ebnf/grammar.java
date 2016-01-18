package sun.misc.unreal.ebnf;

import bbcursive.lib.repeat_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum grammar {
    ;
    public static final UnaryOperator<ByteBuffer> grammar = repeat_.repeat(rule.rule);
}
