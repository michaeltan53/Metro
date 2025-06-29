package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    // create deck at the beginning of the game - 60 x tiles, with
    // 4 copies of tiles aacb, cbaa, acba, baac, and aaaa
    // 3 copies of tiles cbcb and bcbc, and
    // 2 copies of all remaining tiles: cccc, bbbb, dacc, cdac, ccda, accd, dbba, adbb, badb, bbad, ddbc, cddb, bcdd, dbcd, adad, dada and dddd

    public static final ArrayList<String> TILES_IN_DECK = new ArrayList<String>(
            Arrays.asList("aacb", "aacb", "aacb", "aacb",  // 4x tiles
                    "cbaa", "cbaa", "cbaa", "cbaa",
                    "acba", "acba", "acba", "acba",
                    "baac", "baac", "baac", "baac",
                    "aaaa", "aaaa", "aaaa", "aaaa",
                    "cbcb", "cbcb", "cbcb",  // 3x tiles
                    "bcbc", "bcbc", "bcbc",
                    // 2x tiles
                    "cccc", "bbbb", "dacc", "cdac", "ccda", "accd", "dbba", "adbb", "badb", "bbad", "ddbc", "cddb", "bcdd", "dbcd", "adad", "dada", "dddd",
                    "cccc", "bbbb", "dacc", "cdac", "ccda", "accd", "dbba", "adbb", "badb", "bbad", "ddbc", "cddb", "bcdd", "dbcd", "adad", "dada", "dddd"));

}
