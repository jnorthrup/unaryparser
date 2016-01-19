package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public enum rhs_ {
    ;
    public static final UnaryOperator<ByteBuffer> rhs = anyOf_.anyOf(identifier_.identifier, terminal_.terminal, optional_.optional, repeating_.repeating, grouping_.grouping, firstOf_.firstOf, listOf_.listOf);
}
