package sun.misc.unreal.ebnf;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static java.lang.Character.isAlphabetic;

/**
 * Created by jim on 1/17/16.
 */
public class word {
    public static final UnaryOperator<ByteBuffer> word = b -> {
        if (null == b) return null;
        boolean rem;
        while ((rem=b.hasRemaining() )&& isAlphabetic(((ByteBuffer) b.mark()).get() & 0xff)) ;
        if(rem) {
            b.reset();
        }
        return b;
    };
}
