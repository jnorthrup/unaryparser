package sun.misc.unreal;

import bbcursive.lib.confix_;
import bbcursive.std;
import bbcursive.std.traits;
import bbcursive.vtables._edge;
import bbcursive.vtables._ptr;
import junit.framework.TestCase;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.function.UnaryOperator;

import static bbcursive.lib.chlit_.chlit;
import static bbcursive.std.bb;
import static sun.misc.unreal.ebnf.grammar_.grammar;
import static sun.misc.unreal.ebnf.letter_.letter;
import static sun.misc.unreal.ebnf.terminal_.terminal;
import static sun.misc.unreal.ebnf.word_.word;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest extends TestCase {
    public static final String nars =
                "         task = [budget] sentence;\n" +
                "         sentence = statement\".\" [tense] [truth]\n" +
                "                    | statement\"?\" [tense] [truth]\n" +
                "                    | statement\"@\" [tense] [truth]\n" +
                "                    | statement\"!\" [tense] [truth]  ;\n" ;
    @Test public void testNars() throws URISyntaxException {/*
        std.flags.get().put(traits.skipWs, Boolean.TRUE);
        std.flags.get().put(traits.backtrackOnNull, Boolean.TRUE);
        std.flags.get().put(traits.debug, Boolean.TRUE);*/
        ByteBuffer bb = bb(nars, terminal);
        TestCase.assertNotNull(bb);

        bb = bb(nars, grammar);
        TestCase.assertNotNull(bb);

        std.getOutbox().set((_edge<_edge<Set<traits>, _edge<UnaryOperator<ByteBuffer>, Integer>>, _ptr> edge_ptr_edge) -> {
            // shake the tree in intellij.  exhaust core(), location() fanout for a representational constant
            // automate later.
            _edge<_edge<Set<traits>, _edge<UnaryOperator<ByteBuffer>, Integer>>, _ptr> edge_ptr_edge1 = edge_ptr_edge;
            _ptr location = edge_ptr_edge1.location();
            Integer startPosition = location.location();
            ByteBuffer byteBuffer = location.core();
            _edge<Set<traits>, _edge<UnaryOperator<ByteBuffer>, Integer>> set_edge_edge = edge_ptr_edge1.core();
            Set<traits> traitsSet = set_edge_edge.core();
            _edge<UnaryOperator<ByteBuffer>, Integer> operatorIntegerEdge = set_edge_edge.location();
            Integer endPosition = operatorIntegerEdge.location();
            UnaryOperator<ByteBuffer> unaryOperator = operatorIntegerEdge.core();

            System.err.println("+++ "+ unaryOperator +" "+ new Integer[]{startPosition, endPosition}.toString() +" "+ traitsSet);
        });
    }

    @Test
    public void testConfix() {
        ByteBuffer wrap;
        wrap = ByteBuffer.wrap("a=b;".getBytes());
        TestCase.assertNotNull(bb(wrap, letter, confix_.confix("=;", letter)));
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