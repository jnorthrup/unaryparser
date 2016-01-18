package sun.misc.unreal;

import bbcursive.lib.BackTrackingParser;
import bbcursive.lib.confix;
import junit.framework.TestCase;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;
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
public class EbnfTest extends TestCase {
    @Test public void testNars() throws URISyntaxException {

        System.err.println(""+getClass().getResource("/nars.ebnf") );



    };
    @Test
    public void testConfix() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("a=b;".getBytes());
        assertNotNull(bb(wrap, letter, confix.confix("=;", letter)));
    }

    @Test
    public void testWord() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("aa".getBytes());
        ByteBuffer bb = bb(wrap, word);
        assertNotNull(bb);
    }

    @Test
    public void testLetter() {
        ByteBuffer wrap = ByteBuffer.wrap("a".getBytes());
        assertNotNull(bb(wrap, chlit("a")));
    }

    @Override
    protected void setUp() throws Exception {
        BiFunction<ByteBuffer, UnaryOperator<ByteBuffer>[], ByteBuffer> rewindingParser;
        rewindingParser = new BackTrackingParser();
        BiFunction<ByteBuffer, UnaryOperator<ByteBuffer>[], ByteBuffer> byteBufferByteBufferBiFunction = rewindingParser;
        getTheParser().set(byteBufferByteBufferBiFunction);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}