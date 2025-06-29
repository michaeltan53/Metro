package comp1110.ass2;

import javafx.util.Pair;

public class Tile {
    private Orientation o1;
    private Orientation o2;
    private Orientation o3;
    private Orientation o4;
    private Location location;


    public Tile(Orientation o1,Orientation o2,Orientation o3, Orientation o4,Location location){
        this.o1=o1;
        this.o2=o2;
        this.o3=o3;
        this.o4=o4;
        this.location=location;
    }

    public void shuffleTiles() {
        // have random number generator change the order of the tiles, done on startup
    }

    public Orientation geto1() { return o1;}
    public Orientation geto2() { return o2;}
    public Orientation geto3() { return o3;}
    public Orientation geto4() { return o4;}

    public void setO1(Orientation o1) {this.o1 = o1;}

    public void setO2(Orientation o2) {this.o2 = o2;}

    public void setO3(Orientation o3) {this.o3 = o3;}

    public void setO4(Orientation o4) {this.o4 = o4;}

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String toString() {
        return " orientation " + o1 + o2 + o3 + o4 + "location " + location;
    }

    //Find the location and the next index of the second tile for a train will pass.
    public static Pair<Location, Integer> sndLoc(Location loc, String fstTile, int index, int k) {
        Location startLoc = new Location(Integer.parseInt(fstTile.substring(4, 5))
                , Integer.parseInt(fstTile.substring(5)));
        boolean sameLoc = startLoc.getX() == loc.getX() && startLoc.getY() == loc.getY();

        //If there is a tile which has the same location.
        if (sameLoc) {
            if (fstTile.charAt(index) == 'a') {
                if (index == 0) {
                    Location l = new Location(startLoc.getX() + 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 0);
                    return p;
                } else if (index == 1) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() - 1);
                    Pair<Location, Integer> p = new Pair<>(l, 1);
                    return p;
                } else if (index == 2) {
                    Location l = new Location(startLoc.getX() - 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 2);
                    return p;
                } else {
                    Location l = new Location(startLoc.getX(), startLoc.getY() + 1);
                    Pair<Location, Integer> p = new Pair<>(l, 3);
                    return p;
                }
            } else if (fstTile.charAt(index) == 'b') {
                if (index == 0) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() + 1);
                    Pair<Location, Integer> p = new Pair<>(l, 3);
                    return p;
                } else if (index == 1) {
                    Location l = new Location(startLoc.getX() + 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 0);
                    return p;
                } else if (index == 2) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() - 1);
                    Pair<Location, Integer> p = new Pair<>(l, 1);
                    return p;
                } else {
                    Location l = new Location(startLoc.getX() - 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 2);
                    return p;
                }
            } else if (fstTile.charAt(index) == 'c') {
                if (index == 0) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() - 1);
                    Pair<Location, Integer> p = new Pair<>(l, 1);
                    return p;
                } else if (index == 1) {
                    Location l = new Location(startLoc.getX() - 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 2);
                    return p;
                } else if (index == 2) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() + 1);
                    Pair<Location, Integer> p = new Pair<>(l, 3);
                    return p;
                } else {
                    Location l = new Location(startLoc.getX() + 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 0);
                    return p;
                }
            } else {
                //If the orientation of the first entrance is 'd'
                //this path will got zero point, so I just let it stops.
                if (index == 0) {
                    Location l = new Location(startLoc.getX() - 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 2);
                    return p;
                } else if (index == 1) {
                    Location l = new Location(startLoc.getX(), startLoc.getY() + 1);
                    Pair<Location, Integer> p = new Pair<>(l, 3);
                    return p;
                } else if (index == 2) {
                    Location l = new Location(startLoc.getX() + 1, startLoc.getY());
                    Pair<Location, Integer> p = new Pair<>(l, 0);
                    return p;
                } else {
                    Location l = new Location(startLoc.getX(), startLoc.getY() - 1);
                    Pair<Location, Integer> p = new Pair<>(l, 1);
                    return p;
                }
            }
        } else {
            //if the first location is not in the placement
            //this will also be 0, so let it stop, too.
            Location l = new Location(-1, -1);
            Pair<Location, Integer> p = new Pair<>(l, -1);
            return p;
        }
    }

}
