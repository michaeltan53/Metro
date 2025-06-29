package comp1110.ass2;

public class Player {

    // contains cumulative final score, after trains paths are resolves
    // and which train stations are associated with this

    // associated for individual players to keep track of their stations/trains

    public final String name;
    private String holdingTile;  // optional tile that may be held by the player
    public final Integer[] startingStations;  // array of stations player has assigned at game start
    public int score;  // final score - accumulation of each train/path.


    public Integer[] getStartingStations(int numberOfPlayers) {
        return startingStations;
    }

    public Player(String name, Integer[] startingStations) {
        this.name = name;
        this.startingStations = startingStations;
        this.holdingTile = null;    // initially the player has no tiles in their hand
    }

    public int updateScore () {
        // if Station[x].Path.isPathComplete(), this.score += Station[x].Path.pathcount
        return this.score; }
    public String getName() {
        return name;
    }

    public String getHoldingTile() {
        return holdingTile;   // catch the null exception in calling function
    }

    public void setHoldingTile(String holdingTile) {
        this.holdingTile = holdingTile;
    }
}
