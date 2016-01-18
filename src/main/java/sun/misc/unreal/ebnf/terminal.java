package sun.misc.unreal.ebnf;

import bbcursive.ann.Skipper;
import bbcursive.lib.anyOf;
import bbcursive.lib.chlit;
import bbcursive.lib.repeat_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum terminal {
    ;
    @Skipper
    public static final UnaryOperator<ByteBuffer> terminal = anyOf.anyOf(chlit.chlit('\''), character.character, repeat_.repeat(character.character), anyOf.anyOf(chlit.chlit('\''),
            chlit.chlit('"')), character.character, repeat_.repeat(character.character), chlit.chlit('"'));
}
