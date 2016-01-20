package sun.misc.unreal;

import bbcursive.lib.confix_;
import bbcursive.std;
import junit.framework.TestCase;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import static bbcursive.lib.chlit_.chlit;
import static bbcursive.std.bb;
import static bbcursive.std.flags;
import static sun.misc.unreal.ebnf.grammar_.grammar;
import static sun.misc.unreal.ebnf.letter_.letter;
import static sun.misc.unreal.ebnf.terminal_.terminal;
import static sun.misc.unreal.ebnf.word_.word;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest extends TestCase {
    public static final String nars =
                " task = [budget] sentence;\n" +
                " sentence = statement\".\" [tense] [truth]\n" +
                "            | statement\"?\" [tense] [truth]\n" +
                "            | statement\"@\" [tense] [truth]\n" +
                "            | statement\"!\" [tense] [truth]  ;\n" ;
    @Test public static void testNars() throws URISyntaxException {/*
        std.flags.get().put(traits.skipWs, Boolean.TRUE);
        std.flags.get().put(traits.backtrackOnNull, Boolean.TRUE);
        std.flags.get().put(traits.debug, Boolean.TRUE);*/
        flags.get().add(std.traits.skipWs);
        flags.get().add(std.traits.backtrackOnNull);


        ByteBuffer bb = bb(nars, terminal());
        TestCase.assertNotNull(bb);
        bb = bb(nars, grammar);
        TestCase.assertNotNull(bb);
    }

    @Test
    public void testConfix() {
        ByteBuffer wrap;
        flags.get().clear();
        TestCase.assertNotNull(bb( "a=b;", letter, confix_.confix("=;", letter)));
        System.err.println("-----");
        flags.get().add(std.traits.skipWs);
        flags.get().add(std.traits.backtrackOnNull);
        TestCase.assertNotNull(bb( "a=b;", letter, confix_.confix("=;", letter)));
        System.err.println("-----");
        flags.get().clear();
        TestCase.assertNotNull(bb( "a=b;", letter, confix_.confix("=;", letter)));
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