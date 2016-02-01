package sun.misc.unreal.nars;

import bbcursive.std;
import org.junit.Test;

import static bbcursive.lib.backtrack_.backtracker;
import static bbcursive.lib.infix_.infix;
import static bbcursive.std.bb;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static sun.misc.unreal.nars.nars.ARTIFACT;
import static sun.misc.unreal.nars.nars.statement;

/**
 * Created by jim on 1/27/16.
 */
public class narsTest {

    @Test
    public void testsmts() throws Exception {
         assertNotNull(bb("< chess --> competition >", backtracker( statement())));
    }

    @Test
    public void testsmta() throws Exception {
        std.flags.get().clear( );
        assertNotNull(bb("<chess-->competition>", infix(statement())));
     }

    @Test
    public void testTerm() throws Exception {
        std.flags.get().clear( );
        assertNotNull(bb(ARTIFACT+"chess", backtracker(statement())));
     }
    @Test
    public void testWord() throws Exception {
        std.flags.get().clear( );
        assertNull(bb("chess", backtracker(statement())));
     }

}