package sun.misc.unreal;

import bbcursive.std;
import junit.framework.TestCase;
import org.junit.Test;

import java.nio.ByteBuffer;

import static bbcursive.std.confix;
import static sun.misc.unreal.Ebnf.letter;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest extends TestCase{
   
    @Test public  void testConfix() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("a=b;".getBytes());
        assertNotNull( std.bb(wrap,   EbnfPublish.letter) ) ;
        assertNotNull( std.bb(wrap,   confix("=;", letter))) ;
        assertNotNull( std.bb(wrap,   EbnfPublish.letter, confix("=;", letter))) ;
        assertNotNull( std.bb(wrap,   EbnfPublish.letter, confix("=;", letter))) ;
    }

    @Test public  void testWord() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("aa".getBytes());
        ByteBuffer bb = std.bb(wrap, EbnfPublish.word);
        assertNotNull(bb);
    }

    @Test
    public  void testLetter() {
        ByteBuffer wrap = ByteBuffer.wrap("a".getBytes());
        assertNotNull(std.bb(wrap, std.chlit("a")));
    }
//
//    @Override
//    protected void setUp() throws Exception {
//        BiFunction<ByteBuffer, UnaryOperator<ByteBuffer>[], ByteBuffer> byteBufferByteBufferBiFunction = (b, ops) -> {
//            ByteBuffer r = null;
//            if (null != b) {
//                int limit = b.limit();
//                int position = b.position();
//                UnaryOperator<ByteBuffer> op = null;
//                try {
//                    switch (ops.length) {
//                        case 0:
//                            r = b;
//                            break;
//                        case 1:
//                            r = (op = ops[0]).apply(b);
//                            break;
//                        default:
//                            UnaryOperator<ByteBuffer>[] ops1 = Arrays.copyOfRange(ops, 1, ops.length);
//                            r =std.bb( (op = ops[0]).apply(b), ops1);
//
//                            break;
//                    }
//                } catch (Throwable e) {
//                    e.printStackTrace();
//                }
//
//                if (null == r) {
//                    std.bb(b, std.lim(limit), std.pos(position));
//                } else {
//                    std.log(std.bb(b, ByteBuffer::duplicate, std.lim(position), ByteBuffer::slice), "+++ " + Lookup.apply(op) + " @" + position);
//                }
//            }
//            return r;
//
//        };
//        std.getTheParser().set(byteBufferByteBufferBiFunction);
//    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}