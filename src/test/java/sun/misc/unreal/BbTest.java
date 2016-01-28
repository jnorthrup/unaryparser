package sun.misc.unreal;

import bbcursive.std;
import junit.framework.TestCase;
import org.junit.Test;
import sun.misc.unreal.nars.nars;

import java.nio.ByteBuffer;

import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.confix_.confix;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.lib.skipper_.skipper;
import static bbcursive.std.bb;
import static bbcursive.std.flags;
import static sun.misc.unreal.ebnf.letter_.letter;
import static sun.misc.unreal.ebnf.word_.word;

/**
 * Created by jim on 1/16/16.
 */
public class BbTest extends TestCase {

  @Test
    public void testAny() {
       assertNotNull(bb("abcde", repeat(anyOf("abcde"))));

//       flags.get().add(std.traits.backtrackOnNull);
       assertNotNull(bb(" <=> ",skipper( (anyOf(nars.Relation.values())))));


  }
    @Test
    public void testConfix() {
        ByteBuffer wrap;
        flags.get().clear();
        TestCase.assertNotNull(bb( "a=b;", letter, confix("=;", letter)));
        System.err.println("-----");
        flags.get().add(std.traits.skipWs);
        flags.get().add(std.traits.backtrackOnNull);
        TestCase.assertNotNull(bb( "a=b;", letter, confix("=;", letter)));
        System.err.println("-----");
        flags.get().clear();
        TestCase.assertNotNull(bb( "a=b;", letter, confix("=;", letter)));
    }

    @Test
    public void testWord() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("aa".getBytes());
        ByteBuffer bb = bb(wrap, word);
        TestCase.assertNotNull(bb);
    }

    @Test
    public void testLetter() {
        ByteBuffer wrap = ByteBuffer.wrap("a".getBytes());
        TestCase.assertNotNull(bb(wrap, chlit("a")));
    }

    @Override
    protected void setUp() throws Exception {

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}