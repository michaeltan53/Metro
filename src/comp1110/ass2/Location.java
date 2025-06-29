package comp1110.ass2;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int ROW;
    private int COLUMN;

    public Location(int x, int y) {
        this.ROW = x;
        this.COLUMN = y;
    }

    public void setX(int x1) {
        ROW = x1;
    }
    public void setY(int y1) {
        COLUMN = y1;
    }

    public int getX() {
        return ROW;
    }
    public int getY() {
        return COLUMN;
    }


    @Override
    public String toString() {
        return "" + ROW + COLUMN;
    }

    public Location getLocation(){
        return new Location(getX(), getY());
    }

    public static Location[] getLocsFromSeq(String placementSequence) {
        List<Location> locs = new ArrayList<>();
        for (int i = 0; i < placementSequence.length() / 6; i++) {
            int locX = Integer.parseInt(placementSequence.charAt(i * 6 + 5)+"");
            int locY = Integer.parseInt(placementSequence.charAt(i * 6 + 4)+"");
            locs.add(new Location(locX,locY));
        }
        Location[] arr = new Location[locs.size()];
        return locs.toArray(arr);
    }
}