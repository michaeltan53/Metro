# New Code for Deliverable D2D

## < u6877955 > < Hongbin Wu >

For Deliverable D2D, I contributed the following new statements of original code:

-Metro.java:Line 141-184
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


(List at least 10, and include line numbers.)
