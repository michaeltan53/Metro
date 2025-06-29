package comp1110.ass2;

public class Path {

    // This class is to follow the path generated for each train leaving an edge station.
    // It returns a count to the station owner (Player) when resolved.

    public int pathCount; // number of links in path, to contribute to score, x2 if joined to centre
    public final Station originStation; // this is the owner of the path - station it originates from
    public String pathFromStation; // string of set of tiles played which train passes through - possibly just boardString?

    public Path(Station originStation, String pathFromStation) {
        this.originStation = originStation;
        this.pathFromStation = pathFromStation;
        this.pathCount = pathFromStation.length()/6;
    }

    public boolean isPathComplete(Station station){ return true;}

    //Check whether a path will loop back to the station at first move.
    public static boolean isInvalidPath(Location loc, String fstTile, int index) {
        if (fstTile.substring(4, 6).equals(loc)) {
            if ((fstTile.charAt(index) == 'b' || fstTile.charAt(index) == 'c')
                    && (loc.toString().equals("00") || loc.toString().equals("07") ||
                    loc.toString().equals("70") || loc.toString().equals("77"))) {
                return true;
            } else if (fstTile.charAt(index) == 'd') {
                if (index == 0 && loc.getX() == 0) {
                    return true;
                } else if (index == 1 && loc.getY() == 7) {
                    return true;
                } else if (index == 2 && loc.getX() == 7) {
                    return true;
                } else if (index == 3 && loc.getY() == 0) {
                    return true;
                }
            }
        }
        return false;
    }



}
