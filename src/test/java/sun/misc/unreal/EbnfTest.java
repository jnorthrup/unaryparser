package sun.misc.unreal;

import bbcursive.std;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest {
    @Test
    public void testParse() throws Exception {
        String s = "a=b;";
        ByteBuffer wrap = ByteBuffer.wrap(s.getBytes());
        ByteBuffer bb = std.bb(wrap, Ebnf.grammar);
        System.err.println("");
    }
}