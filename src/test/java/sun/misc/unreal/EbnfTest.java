package sun.misc.unreal;

import bbcursive.lib.confix;
import bbcursive.std;
import junit.framework.TestCase;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import static bbcursive.lib.chlit.chlit;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.grammar.grammar;
import static sun.misc.unreal.ebnf.letter.letter;
import static sun.misc.unreal.ebnf.terminal.terminal;
import static sun.misc.unreal.ebnf.word.word;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest extends TestCase {
    public static final java.lang.String nars =

        "         task = [budget] sentence;\n" +
                "\n" +
                "         sentence = statement\".\" [tense] [truth]\n" +
                "                    | statement\"?\" [tense] [truth]\n" +
                "                    | statement\"@\" [tense] [truth]\n" +
                "                    | statement\"!\" [tense] [truth]  ;\n" +
                " ";
    @Test public void testNars() throws URISyntaxException {
        std.flags.get().put(std.traits.skipWs, Boolean.TRUE);
        std.flags.get().put(std.traits.backtrackOnNull, Boolean.TRUE);
        std.flags.get().put(std.traits.debug, Boolean.TRUE);
        ByteBuffer bb = bb(nars, terminal);
        assertNotNull(bb);

        bb = bb(nars, grammar);
        assertNotNull(bb);
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

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}