package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.Arrays;
import static org.junit.Assert.assertSame;

public class getLocsFromSeqTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1600);

    private void testT(String placementSequence,  Location[] locs) {
        Location[] a = Location.getLocsFromSeq(placementSequence);
        assertSame("Expected " + Arrays.toString(locs) + " for input String " + placementSequence +
                ", but got " + Arrays.toString(a) + ".", a, locs);
    }

    @Test
    public void testOnePlacement() {
        testT("aaaa00", new Location[]{new Location(0,0)});
    }

    @Test
    public void testTwoPlacement() {
        testT("aaaa01bbbb00", new Location[]{new Location(1,0),new Location(0,0)});
    }
}