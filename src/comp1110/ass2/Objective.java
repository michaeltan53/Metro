package comp1110.ass2;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_MULTIPLYPeer;

import java.util.Scanner;

public class Objective {

    public int numberOfPlayers;
    public static Difficulty diff;
    public Player[] players;

    // this is for the objectives of the game - aims, difficulty levels and overall mechanics
    // setup - allocate stations based on number of players

    public Objective(int numberOfPlayers, int difficulty) {

        if (numberOfPlayers > 6 || numberOfPlayers < 2) {
            // invalid number of players - please try again
            return;
        }
        this.numberOfPlayers = numberOfPlayers;

        Integer[][] startingStations = allocateStations(numberOfPlayers);   // allocate stations for each player

        this.players = new Player[numberOfPlayers];

        switch (difficulty) {
            case 0: {
                this.diff = Difficulty.BEGINNER;
            }
            case 1: {
                this.diff = Difficulty.INTERMEDIATE;
            }
            case 2: {
                this.diff = Difficulty.ADVANCED;
            }
        }

        // set up the play: ask for players names and allocate their starting stations
        Scanner sin = new Scanner(System.in);

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Please enter player " + (i + 1) + "'s name: ");
            String input = sin.nextLine();

            this.players[i] = new Player(input, startingStations[i]);
        }
    }

    enum Difficulty {           // set difficulty in the setup phase of the game.
        BEGINNER, INTERMEDIATE, ADVANCED
    }

    public static Integer[][] allocateStations(int numberOfPlayers) {  // note numberOfPlayers 2-6
        switch (numberOfPlayers) {
            case 2: {
                return new Integer[][]{
                        {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31},
                        {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32}
                };
            }
            case 3: {
                return new Integer[][]{
                        {1, 4, 6, 11, 15, 20, 23, 25, 28, 31},
                        {2, 7, 9, 12, 14, 19, 22, 27, 29, 32},
                        {3, 5, 8, 10, 13, 18, 21, 24, 26, 30}
                };
            }
            case 4: {
                return new Integer[][]{
                        {4, 7, 11, 16, 20, 23, 27, 32},
                        {3, 8, 12, 15, 19, 24, 28, 31},
                        {1, 6, 10, 13, 18, 21, 25, 30},
                        {2, 5, 9, 14, 17, 22, 26, 29}
                };
            }
            case 5: {
                return new Integer[][]{
                        {1, 5, 10, 14, 22, 28},
                        {6, 12, 18, 23, 27, 32},
                        {3, 7, 15, 19, 25, 29},
                        {2, 9, 13, 21, 26, 30},
                        {4, 8, 11, 20, 24, 31}
                };
            }
            case 6: {
                return new Integer[][]{
                        {1, 5, 10, 19, 27},
                        {2, 11, 18, 25, 29},
                        {4, 8, 14, 21, 26},
                        {6, 15, 20, 24, 31},
                        {3, 9, 13, 23, 30},
                        {7, 12, 22, 28, 32}
                };
            }
        }
        return new Integer[][]{{0},{0}};  // this should never be called, check number of players in separate test.
    }

}


