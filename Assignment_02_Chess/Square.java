public class Square {
    private int x; //column
    private int y; //row
    private String chessID;

    public Square(int column, int row){
        this.x = column;
        this.y = row;
    }
    // read-only getter for values x and y and for arithmetic chessboard position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    //getter for a comparison of the players input like "start": b2 "end": b4
    public String getChessID() {
        char c =(char)(x+97);
        int r = 8-y;
        return c + String.valueOf(r);
    }

}
