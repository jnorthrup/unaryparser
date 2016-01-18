package bbcursive.lib;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import static bbcursive.std.bb;

/**
 * Created by jim on 1/17/16.
 */
public class BackTrackingParser implements BiFunction<ByteBuffer, UnaryOperator<ByteBuffer>[], ByteBuffer> {
    @Override
    public ByteBuffer apply(ByteBuffer b, UnaryOperator<ByteBuffer>[] ops) {
        if (null == b || !b.hasRemaining()) return b;
        int pos1 = b.position();
        int lim1 = b.limit();

        ByteBuffer r = null;
        UnaryOperator<ByteBuffer> op = null;
        if (null != b) {
            int position = b.position();
            switch (ops.length) {
                case 0:
                    r = b;
                    break;
                case 1:
                    r = (op = ops[0]).apply(b);
                    break;
                default:
                    op = ops[0];
                    UnaryOperator<ByteBuffer>[] ops1 = Arrays.copyOfRange(ops, 1, ops.length);
                    r = bb(op.apply(b), ops1);
                    break;
            }
        }
        if (null != r) {
            int pos2 = b.position();
            ByteBuffer bbbb = ((ByteBuffer) b.duplicate().position(pos1).limit(pos2)).slice();
            String str = StandardCharsets.UTF_8.decode(bbbb).toString();
            System.err.println("+++ @" + pos1 + " " + str + "  : " + op);
        } else b.position(pos1).limit(lim1);
        return r;
    }
}
