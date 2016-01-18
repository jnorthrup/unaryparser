package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf;
import bbcursive.lib.chlit;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum character {
    ;
    public static final UnaryOperator<ByteBuffer> character = anyOf.anyOf(letter.letter, digit.digit, symbol.symbol, chlit.chlit('_'));
}
