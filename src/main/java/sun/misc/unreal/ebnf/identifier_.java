package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf;
import bbcursive.lib.anyOf_;
import bbcursive.lib.chlit_;
import bbcursive.lib.opt;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum identifier_ {
    ;
    public static final UnaryOperator<ByteBuffer> identifier = allOf.allOf(letter_.letter, opt.opt(anyOf_.anyOf(letter_.letter, digit.digit, chlit_.chlit('_'))));
}
