package sun.misc.unreal.ebnf;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Skipper;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.repeat_.repeat;
import static sun.misc.unreal.ebnf.character_.*;

/**
 * Created by jim on 1/17/16.
 */
public enum terminal_ {
    ;
    @Skipper@Backtracking
    public static final UnaryOperator<ByteBuffer> terminal = anyOf(chlit('\''), character, repeat(character), anyOf(chlit('\''),
            chlit('"')), character, repeat(character), chlit('"'));
}
