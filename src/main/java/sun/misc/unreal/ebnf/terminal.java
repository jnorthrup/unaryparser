package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf;
import bbcursive.lib.chlit;
import bbcursive.lib.repeat;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum terminal {
    ;
    public static final UnaryOperator<ByteBuffer> terminal = anyOf.anyOf(chlit.chlit('\''), character.character, repeat.repeat(character.character), anyOf.anyOf(chlit.chlit('\''),
            chlit.chlit('"')), character.character, repeat.repeat(character.character), chlit.chlit('"'));
}
