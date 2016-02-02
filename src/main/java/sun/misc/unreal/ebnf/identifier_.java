package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.digit_.digit;
import static sun.misc.unreal.ebnf.letter_.letter;

/**
 * Created by jim on 1/17/16.
 */
public enum identifier_ {
    ;
    public static final UnaryOperator<ByteBuffer> identifier (){

        return new UnaryOperator<ByteBuffer>() {
        @Override
        public String toString() {
            return "identifier";
        }

        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer,allOf(letter, repeat(anyOf_.anyOf(letter, digit, chlit('_')))));
        }
    };}

}
