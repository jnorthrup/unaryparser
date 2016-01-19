package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.repeat_.repeat;

/**
 * Created by jim on 1/17/16.
 */
public enum grammar_ {
    ;@Skipper@Backtracking
    public static final UnaryOperator<ByteBuffer> grammar = repeat(rule_.rule);
}
