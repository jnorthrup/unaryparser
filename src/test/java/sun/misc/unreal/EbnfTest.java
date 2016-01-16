package sun.misc.unreal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jim on 1/16/16.
 */
public class EbnfTest {

    @Before
    public void setUp() throws Exception {

        URI uri = getClass().getResource("/nars.bnf").toURI();
        Files.readAllBytes(Paths.get(uri));


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testName() throws Exception {

    }

    @Test
    public void testOrdinal() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testClone() throws Exception {

    }

    @Test
    public void testCompareTo() throws Exception {

    }

    @Test
    public void testGetDeclaringClass() throws Exception {

    }

    @Test
    public void testValueOf() throws Exception {

    }

    @Test
    public void testFinalize() throws Exception {

    }
}