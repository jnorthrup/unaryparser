package sun.misc.unreal;

import bbcursive.lib.confix;
import junit.framework.TestCase;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import static bbcursive.lib.chlit.chlit;
import static bbcursive.std.bb;
import static bbcursive.std.getTheParser;
import static sun.misc.unreal.ebnf.letter.letter;
import static sun.misc.unreal.ebnf.word.word;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest extends TestCase{
   
    @Test public  void testConfix() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("a=b;".getBytes());
        assertNotNull( bb(wrap,    letter, confix.confix("=;", letter))) ;
    }

    @Test public  void testWord() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("aa".getBytes());
        ByteBuffer bb = bb(wrap, word);
        assertNotNull(bb);
    }

    @Test
    public  void testLetter() {
        ByteBuffer wrap = ByteBuffer.wrap("a".getBytes());
        assertNotNull(bb(wrap, chlit("a")));
    }

    @Override
    protected void setUp() throws Exception {
        BiFunction<ByteBuffer, UnaryOperator<ByteBuffer>[], ByteBuffer> byteBufferByteBufferBiFunction = (b, ops) -> {
            if(null == b||!b.hasRemaining())return b;
            int pos1 = b.position();
            int lim1 = b.limit();

            ByteBuffer r = null;
            UnaryOperator<ByteBuffer> op = null;
            int position = 0;
            if (null != b) {
                position = b.position();
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
//            if (r != null&& op1 !=null) log.log(op1, "===", "@" + position);


            int pos2 = b.position();
            ByteBuffer bbbb = ((ByteBuffer) b.duplicate().position(pos1).limit(pos2)).slice();
            String str = StandardCharsets.UTF_8.decode(bbbb).toString();
            System.err.println("+++ @"+pos1+" "+ str+  "  : "+op);
            return r;
         };
        getTheParser().set(byteBufferByteBufferBiFunction);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}