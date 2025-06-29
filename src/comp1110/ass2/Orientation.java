package comp1110.ass2;

public enum Orientation {
    A,B,C,D;
    private Orientation orientation;
    public static Orientation fromChar(char x){
        switch(x){
            case 'a':
                return A;
            case 'b':
                return B;
            case 'c':
                return C;
            case 'd':
                return D;
            default:
                throw new IllegalArgumentException("Invalid tile type: " + x);
        }
    }
}
