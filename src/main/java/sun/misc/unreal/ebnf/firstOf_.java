package sun.misc.unreal.ebnf;

import bbcursive.lib.allOf_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.chlit_.chlit;
import static sun.misc.unreal.ebnf.rhs_.rhs;

/**
 * Created by jim on 1/17/16.
 */
public enum firstOf_ {
    ;
    public static final UnaryOperator<ByteBuffer> firstOf = allOf_.allOf(rhs(), chlit("|"), rhs());
}
