package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.character_.*;

/**
 * Created by jim on 1/17/16.
 */
public enum terminal_ {
    ;

    public static final UnaryOperator<ByteBuffer> terminal() {
        return new ByteBufferUnaryOperator();
    }
    @Skipper
    @Backtracking
      static class ByteBufferUnaryOperator implements UnaryOperator<ByteBuffer> {
        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return bb(buffer, anyOf(chlit('\''), character, repeat(character), anyOf(chlit('\''),
                    chlit('"')), character, repeat(character), chlit('"')));
        }
    }



}
