package sun.misc.unreal.nars;

import bbcursive.std;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static sun.misc.unreal.nars.nars.statement;

/**
 * Created by jim on 1/27/16.
 */
public class narsTest {

    @Test
    public void testsmt() throws Exception {
        std.flags.get().add(std.traits.backtrackOnNull);
        assertNotNull(std.bb("<chess --> competition>", statement()));
    }

    @Test
    public void testTerm() throws Exception {

    }
}