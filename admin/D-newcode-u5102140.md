# New Code for Deliverable D2D

## u5102140 < Karly Winkler >

For Deliverable D2D, I contributed the following new statements of original code:

- Metro.java: Lines 209-303
   public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
          // FIXME Task 9: generate a valid move
  
          String move = "";
          ArrayList<Location> possiblePlaces = findFreeLocations(placementSequence);
  
          ArrayList<Location> removalList = new ArrayList<>();
  
          for (Location loc : possiblePlaces) {
              // System.out.println("Loc in possiblePlaces arrayList: " + loc.toString());
              String possPlace = piece + loc.getX() + loc.getY();
              if (!isPiecePlacementWellFormed(possPlace) || !isPlacementSequenceValid(placementSequence + possPlace) || !isPlacementSequenceWellFormed(placementSequence + possPlace)) {
                  removalList.add(loc);
              }
          }
  
          for (Location loc : removalList)
          {
              possiblePlaces.remove(loc);
              // System.out.println("Location removed: " + loc.toString());
          }

... Metro.java line 276

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


-

(List at least 10, and include line numbers.)
