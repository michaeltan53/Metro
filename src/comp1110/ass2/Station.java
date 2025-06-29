package comp1110.ass2;

public class Station {

    // for the goal locations on the outside of the board (lower scores) and
    // the stations at the centre which give you double score

    public int stationNum; // the number of the station
    //public Location startLoc;  // the starting location of the station
    public Location central;

    public Station(int stationNum) {
        this.stationNum = stationNum;
    }

    public Station(Location central) {
        this.central = central;
    }

    public int getStationNum() {
        return stationNum;
    }

    public Location getCentral() {
        return central;
    }

    @Override
    public String toString() {
        return "" + stationNum;
    }

    //Find the location of the first tile a metro will start.
    public Location getStartLoc(int stationNum) {
        int num = stationNum;
        if (num >= 1 && num <= 8) {
            Location startLoc = new Location(0, 8 - num);
            return startLoc;
        } else if (num >= 9 && num <= 16) {
            Location startLoc = new Location(num - 9, 0);
            return startLoc;
        } else if (num >= 17 && num <= 24) {
            Location startLoc = new Location(7, num - 17);
            return startLoc;
        } else if (num >= 25 && num <= 32) {
            Location startLoc = new Location(32 - num, 7);
            return startLoc;
        } else {
            return getCentral();
        }
    }

    //Find the index of a tile string.
    public int getIndex(int stationNum) {
        int num = stationNum;
        if (num >= 1 && num <= 8) {
            return 0;
        } else if (num >= 9 && num <= 16) {
            return 3;
        } else if (num >= 17 && num <= 24) {
            return 2;
        } else {
            return 1;
        }
    }
}
