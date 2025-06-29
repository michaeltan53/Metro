package comp1110.ass2;

public class Board {
    private String board;
    int col,row;
    public Board(String board){
        this.board=board;
    }
    public Board(int col,int row){
        this.col=col;
        this.row=row;
    }

    //Define the central stations.
    public static boolean isDoublePlace(Location loc){
        if(loc.getX()==3){
            if(loc.getY()==3|loc.getY()==4){
                return true;
            }
        }else if(loc.getX()==4) {
            if (loc.getY() == 3 | loc.getY() == 4) {
                return true;
            }
        }
        return false;
    }

    //Define the situation that there are no valid place.
    public static boolean noValidPlace(String board, Tile tile){
        int total = 0;
        int lim=59;
        if((tile.geto1()==Orientation.B||tile.geto2()==Orientation.B||
                tile.geto3() == Orientation.B || tile.geto4() == Orientation.B ||
                tile.geto1() == Orientation.C || tile.geto2() == Orientation.C ||
                tile.geto3() == Orientation.C || tile.geto4() == Orientation.C
        ) && (board.length() / 6 == 59)) {
            return true;}
        if(tile.geto1()==Orientation.D){
            for(int i = 0; i<board.length()-5; i=i+6){
                if(board.charAt(i+4)!='0'){total++;}
            }
            if (total>=lim-7){return true;}
        }
        if(tile.geto2()==Orientation.D){
            for(int i =0; i<board.length(); i=i+6){
                if(board.charAt(i+5)!='7'){total++;}
            }
            if (total>=lim-7){return true;}
        }
        if(tile.geto3()==Orientation.D){
            for(int i = 0; i<board.length(); i=i+6){
                if(board.charAt(i+4)!='7'){total++;}
            }
            if (total>=lim-7){return true;}
        }
        if(tile.geto4()==Orientation.D){
            for(int i = 0; i<board.length(); i=i+6){
                if(board.charAt(i+5)!='0'){total++;}
            }
            if (total>=lim-7){return true;}
        }
        return false;
    }

    //Define the valid place.
    public static boolean isValidPlace(String board, Location loc){
        Location locUp= new Location(loc.getX(),loc.getY()-1);
        Location locDown= new Location(loc.getX(),loc.getY()+1);
        Location locLeft= new Location(loc.getX()-1,loc.getY());
        Location locRight= new Location(loc.getX()+1,loc.getY());
        if (loc.getX()==0||loc.getY()==0||loc.getX()==7||loc.getY()==7){
            return true;
        }
        if(loc.getX()>7|loc.getY()>7|loc.getX()<0|loc.getY()<0){
            return false;
        }else if(!(board.contains(locUp.toString())||board.contains(locDown.toString())
                ||board.contains(locLeft.toString())||board.contains(locRight.toString()))){
            return false;
        }else if(isDoublePlace(loc)){
            return false;
        }
        return true;
    }
    public String getBoard() {
        return board;
    }
    public String updateBoard(String board){
        return this.board+board;
    }

}
