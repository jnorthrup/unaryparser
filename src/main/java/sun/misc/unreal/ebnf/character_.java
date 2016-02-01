package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf_;
import bbcursive.lib.chlit_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum character_ {
    ;
    public static final UnaryOperator<ByteBuffer> character = anyOf_.anyIn(letter_.letter, digit_.digit, symbol_.symbol, chlit_.chlit('_'));
}
