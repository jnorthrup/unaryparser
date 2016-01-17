package sun.misc.unreal;

import bbcursive.std;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.function.UnaryOperator;

import static bbcursive.std.lim;
import static bbcursive.std.pos;
import static bbcursive.std.str;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest {
    @Test
    public void testParse() throws Exception {


        String s = "a=b;";
        ByteBuffer wrap = ByteBuffer.wrap(s.getBytes());
        std.getTheParser().set((b, ops) -> {
            int opos = b.position();
            int olim = b.limit();
            std.log(b.duplicate(), "+++", " with +++ " + Arrays.deepToString(ops));
            ByteBuffer byteBuffer = null;
            try {
                ByteBuffer r = null;
                e:
                {
                    UnaryOperator<ByteBuffer> op = null;
                    switch (ops.length) {
                        case 0:
                            r = b;
                            break;
                        case 1:
                            r = op.apply(null != (op = ops[0]) ? std.bb(b, Arrays.copyOfRange(ops, 1, ops.length)) : b);//null lambda is noop
                            std.log(Ebnf.registry.get(op), "::=", str(b, ByteBuffer::duplicate, lim(olim), pos(opos), ByteBuffer::slice, lim(b.position() - opos)));
                            break;
                    }
                }
                byteBuffer = r;
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (null == byteBuffer) std.defaultParser(b, lim(olim), pos(opos));
            return byteBuffer;
        });
        ByteBuffer bb = std.bb(wrap, Ebnf.grammar);
        System.err.println("");
    }
}