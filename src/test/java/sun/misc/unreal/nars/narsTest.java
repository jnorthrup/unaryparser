package sun.misc.unreal.nars;

import bbcursive.std;
import org.junit.Test;

import static bbcursive.std.bb;
import static bbcursive.std.traits.backtrackOnNull;
import static junit.framework.TestCase.assertNotNull;
import static sun.misc.unreal.nars.nars.statement;

/**
 * Created by jim on 1/27/16.
 */
public class narsTest {

    @Test
    public void testsmts() throws Exception {
        std.flags.get().add(backtrackOnNull);
         assertNotNull(bb("< chess --> competition >", statement()));
    }

    @Test
    public void testsmta() throws Exception {
        std.flags.get().add(backtrackOnNull);
        assertNotNull(bb("<chess-->competition>", statement()));
     }

    @Test
    public void testTerm() throws Exception {

    }
}