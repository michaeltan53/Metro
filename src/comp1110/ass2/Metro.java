package comp1110.ass2;

import java.util.*;

public class Metro {
    /**
     * Task 2
     * Determine whether a piece placement is well-formed. For a piece
     * placement to be well-formed, it must:
     * - contain exactly six characters;
     * - have as its first, second, third and fourth characters letters between
     * 'a' and 'd' inclusive (tracks); and
     * - have as its fifth and sixth characters digits between 0 and 7 inclusive
     * (column and row respectively).
     *
     * @param piecePlacement A String representing the piece to be placed
     * @return True if this string is well-formed
     * @author Hongbin Wu(u6877955)
     */
    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
        // FIXME Task 2: determine whether a piece placement is well-formed
        if (piecePlacement.length() != 6) {
            return false;
        } else {
            for (int i = 0; i < piecePlacement.length(); i++) {
                if (i < 4) {
                    if (piecePlacement.charAt(i) < 'a' || piecePlacement.charAt(i) > 'd') {
                        return false;
                    }
                } else {
                    if (piecePlacement.charAt(i) < '0' || piecePlacement.charAt(i) > '7') {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * Task 3
     * Determine whether a placement sequence string is well-formed.
     * For a placement sequence to be well-formed, it must satisfy the
     * following criteria:
     * - It must be composed of well-formed tile placements.
     * - For any piece x, there can exist no more instances of x on the board
     * than instances of x in the deck.
     *
     * @param placement A String representing the placement of all tiles on the
     *                  board
     * @return true if this placement sequence is well-formed
     * @author Hongbin Wu(u6877955)
     */
    public static boolean isPlacementSequenceWellFormed(String placement) {
        int num = 1;
        //check the first tile.
        if (placement.length() < 6 & placement.length() > 0) {
            return false;
        }
        for (int i = 0; i <= placement.length() - 5; i = i + 6) {
            String sub = placement.substring(i, i + 6);
            //check each tile is well formed
            if (!isPiecePlacementWellFormed(sub)) {
                return false;
            }
            num++;
        }
        //The board can only has at most 60 tiles.
        return num <= 60;
    }

    /**
     * Task 5
     * Draw a random tile from the deck.
     *
     * @param placementSequence a String representing the sequence of tiles
     *                          that have already been played
     * @param totalHands        a String representing all tiles (if any) in
     *                          all players' hands
     * @return a random tile from the deck
     * @author Karly Winkler(u5102140)
     */
    public static String drawFromDeck(String placementSequence, String totalHands) {
        // FIXME Task 5: draw a random tile from the deck

        String newTile;
        ArrayList<String> possibleTiles;
        possibleTiles = (ArrayList<String>) Deck.TILES_IN_DECK.clone();

        int numTilesPlayed = placementSequence.length() / 6;
        int tilesHeld = totalHands.length() / 4;

        // remove tiles from the placement sequence and tiles being held by players from the deck to get remaining tiles
        if (numTilesPlayed > 0) {
            for (int i = 0; i < numTilesPlayed; i++) {
                System.out.println("Removing from boardstring " + placementSequence.substring((i * 6), (i * 6) + 4));
                possibleTiles.remove(placementSequence.substring((i * 6), (i * 6) + 4));
            }
        }

        if (tilesHeld > 0) {
            for (int i = 0; i < tilesHeld; i++) {
                System.out.println("Removing from hand tiles " + totalHands.substring((i * 4), (i * 4) + 4));
                possibleTiles.remove(totalHands.substring((i * 4), (i * 4) + 4));
            }
        }

        if (possibleTiles.size() == 1) {
            return possibleTiles.get(0);
        } else {
            // choose an index from a RNG and return that tile
            Random rand = new Random();
            int tileNumber = rand.nextInt(possibleTiles.size());
            newTile = possibleTiles.get(tileNumber);
            return newTile;
        }
    }

    /**
     * Task 6
     * Determine if a given placement sequence follows the rules of the game.
     * These rules are:
     * - No tile can overlap another tile, or any of the central stations.
     * - A tile cannot be placed next to one of the central squares unless it
     * continues or completes an existing track.
     * - If a tile is on an edge of the board, it cannot contain a track that
     * results in a station looping back to itself, UNLESS that tile could not
     * have been placed elsewhere.
     * - If a tile is on a corner of the board, it cannot contain a track that
     * links the two stations adjacent to that corner, UNLESS that tile could
     * not have been placed elsewhere.
     *
     * @param placementSequence A sequence of placements on the board.
     * @return Whether this placement string is valid.
     * @author Hongbin Wu(u6877955)
     */
    public static boolean isPlacementSequenceValid(String placementSequence) {
        String[] allPos = new String[placementSequence.length()];
        // FIXME Task 6: determine whether a placement sequence is valid
        for (int i = 0; i <= placementSequence.length() - 5; i = i + 6) {
            //Get the location of each tile.
            String sub = placementSequence.substring(i + 4, i + 6);
            Location l = new Location(Integer.parseInt(sub.substring(0, 1)),
                    Integer.parseInt(sub.substring(1)));
            //Check whether it overlap another tile.
            if (Arrays.asList(allPos).contains(sub)) {
                return false;
            }
            allPos[i] = sub;
            //Check whether the place is the central station or other invalid place(except the
            //situation that the metro loops back to the station in a single tile).
            if (!Board.isValidPlace(placementSequence.substring(0, i), l) || Board.isDoublePlace(l)) {
                return false;
            }
            //Check whether contains a track that results in a station looping back to itself or a
            //track that links the two stations adjacent to that corner.
            else if (((sub.charAt(0) == '0' && placementSequence.charAt(i) == 'd') ||
                    (sub.charAt(0) == '7' && placementSequence.charAt(i + 2) == 'd') ||
                    (sub.charAt(1) == '0' && placementSequence.charAt(i + 3) == 'd') ||
                    (sub.charAt(1) == '7' && placementSequence.charAt(i + 1) == 'd') ||
                    (sub.equals("00") && (placementSequence.charAt(i + 3) == 'b'
                            || placementSequence.charAt(i) == 'c')) ||
                    (sub.equals("07") && (placementSequence.charAt(i) == 'b'
                            || placementSequence.charAt(i + 1) == 'c')) ||
                    (sub.equals("77") && (placementSequence.charAt(i + 1) == 'b'
                            || placementSequence.charAt(i + 2) == 'c')) ||
                    (sub.equals("70") && (placementSequence.charAt(i + 2) == 'b'
                            || placementSequence.charAt(i + 3) == 'c')))) {
                //Check whether there is no other valid place at that moment.
                if (placementSequence.substring(i, i + 4).equals("dddd") && i == 0) {
                    return true;
                }
                Tile tile = new Tile(Orientation.fromChar(placementSequence.charAt(i)),
                        Orientation.fromChar(placementSequence.charAt(i + 1)),
                        Orientation.fromChar(placementSequence.charAt(i + 2)),
                        Orientation.fromChar(placementSequence.charAt(i + 3)), l);
                return Board.noValidPlace(placementSequence.substring(0, i), tile);
            }
        }
        return true;
    }

    /**
     * Task 7
     * Determine the current score for the game.
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @param numberOfPlayers   The number of players in the game
     * @return an array containing the scores for all players
     * @author Hongbin Wu(u6877955)
     */
    public static int[] getScore(String placementSequence, int numberOfPlayers) {
        // FIXME Task 7: determine the current score for the game
        Integer[][] stationList = Objective.allocateStations(numberOfPlayers);
        int[] finalPoint = new int[numberOfPlayers];
        for (int i = 0; i < stationList.length; i++) {
            Integer[] stationsOfPlayer = stationList[i];
            int eachPoint = 0;
            for (int j = 0; j < stationsOfPlayer.length; j++) {
                Station s = new Station(stationsOfPlayer[j]);
                Location startLoc = s.getStartLoc(s.getStationNum());
                int index = s.getIndex(s.getStationNum());
                int onePath = onePathScore(placementSequence, startLoc, index);
                eachPoint = eachPoint + onePath;
            }
            finalPoint[i] = eachPoint;
        }
        return finalPoint;
    }

    public static int onePathScore(String placementSequence, Location startLoc, int index) {
        int onePath = 1;
        for (int k = 0; k <= placementSequence.length() - 5; k = k + 6) {
            String sub = placementSequence.substring(k, k + 6);
            if (Path.isInvalidPath(startLoc, sub, index)) {
                break;
            }
            if (Tile.sndLoc(startLoc, sub, index, k).getValue() == -1) {
                continue;
            } else {
                k = -6;
            }
            if (Tile.sndLoc(startLoc, sub, index, k).getKey().getX() == -1 ||
                    Tile.sndLoc(startLoc, sub, index, k).getKey().getY() == -1 ||
                    Tile.sndLoc(startLoc, sub, index, k).getKey().getX() == 8 ||
                    Tile.sndLoc(startLoc, sub, index, k).getKey().getY() == 8) {
                return onePath;
            } else if (Board.isDoublePlace(Tile.sndLoc(startLoc, sub, index, k).getKey())) {
                return onePath * 2;
            }
            Location startLoc1 = Tile.sndLoc(startLoc, sub, index, k).getKey();
            index = Tile.sndLoc(startLoc, sub, index, k).getValue();
            startLoc = startLoc1;
            onePath++;
        }
        return 0;
    }
    /**
     * Task 9
     * Given a placement sequence string, generate a valid next move.
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @param piece             a four-character String representing the tile to be placed
     * @param numberOfPlayers   The number of players in the game
     * @return                  A valid placement of the tile
     * @author Karly Winkler(u5102140)
     */
    public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
        // FIXME Task 9: generate a valid move

        String move = "";
        ArrayList<Location> possiblePlaces = findFreeLocations(placementSequence);

        Iterator<Location> itr = possiblePlaces.iterator();

        while (itr.hasNext()) {
            // System.out.println("Loc in possiblePlaces arrayList: " + loc.toString());
            Location loc = itr.next();
            String possPlace = piece + loc.getX() + loc.getY();
            if (!isPiecePlacementWellFormed(possPlace) || !isPlacementSequenceValid(placementSequence + possPlace) || !isPlacementSequenceWellFormed(placementSequence + possPlace)) {
                itr.remove();
            }
        }

        System.out.println("Possible moves: " + possiblePlaces.toString());

        if (possiblePlaces.size() == 0) {
            // there are no possible placements for this piece.
            System.out.println("No places available");
            return null;
        }

        Location chosenLoc = possiblePlaces.get(0);  // default to the first available space, to get case where only 1 possible move

        if (possiblePlaces.size() > 1) {
            // If there are multiple places for a piece to be placed:

            if (Objective.diff == Objective.Difficulty.BEGINNER) {
                // choose position at random
                Random rand = new Random();
                chosenLoc = possiblePlaces.get(rand.nextInt(possiblePlaces.size() - 1));
            }
            else {
                // calculate the number of moves the player has left in the game
                int remainingTiles = 60 - placementSequence.length()/6 - 1;
                int maxTurnsRemaining = (int) remainingTiles/numberOfPlayers;

                if (Objective.diff == Objective.Difficulty.INTERMEDIATE) {
                    // make sure each move benefits the current player - extends their current path
                    // TODO
                }
                else {   // advanced case
                    // create a collection - possibly a map - containing the tiles remaining that are available and their probabilities
                    // write an exhaust for all possible completed strings and calculate the score for each one, and choose based on max score and likelihood of success.
                    // TODO
                }
            }
        }

        return piece + chosenLoc.getX() + chosenLoc.getY();
    }

    /**
     * Find available locations on board to place a tile
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @return A list of valid locations on the board where tiles can be placed
     */

    public static ArrayList<Location> findFreeLocations(String placementSequence) {

        //identify available locations left on the board
        // initialise ArrayList of all possible board locations - leave out middle space where station is
        ArrayList<Location> validLocs = new ArrayList<>(60);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && (j == 3 || j == 4)) || (i == 4 && (j == 3 || j == 4))) {
                    continue;
                }
                validLocs.add(new Location(i, j));
            }
        }

        if (placementSequence.length() >= 6) {
            // remove the locations already played
            Location[] playedLocs = Location.getLocsFromSeq(placementSequence);

            for (Location loc1 : playedLocs) {
                validLocs.remove(loc1);
            }
        }

        System.out.println("Available locs: " + validLocs.toString() + " with length " + validLocs.size());

        return validLocs;

    }
}
