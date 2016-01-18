package sun.misc.unreal.ebnf;

import bbcursive.lib.repeat;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class grammar {
    public static final UnaryOperator<ByteBuffer> grammar = repeat.repeat(rule.rule);
}
