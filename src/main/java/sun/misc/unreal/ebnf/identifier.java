package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.anyOf;
import bbcursive.lib.chlit;
import bbcursive.lib.opt;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum identifier {
    ;
    public static final UnaryOperator<ByteBuffer> identifier = allOf.allOf(letter.letter, opt.opt(anyOf.anyOf(letter.letter, digit.digit, chlit.chlit('_'))));
}
