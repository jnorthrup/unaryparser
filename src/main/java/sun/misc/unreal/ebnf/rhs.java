package sun.misc.unreal.ebnf;

import bbcursive.lib.anyOf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/17/16.
 */
public class rhs {
    public static final UnaryOperator<ByteBuffer> rhs = anyOf.anyOf(identifier.identifier, terminal.terminal, optional.optional, repeating.repeating, grouping.grouping, firstOf.firstOf, listOf.listOf);
}
