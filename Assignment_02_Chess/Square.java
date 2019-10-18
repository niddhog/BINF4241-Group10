public class Square {
    private int x; //column
    private int y; //row
    private String chessID;

    public Square(int column, int row){
        this.x = column;
        this.y = row;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getChessID() {
        char c =(char)(x+97);
        int r = 8-y;
        return c + String.valueOf(r);

    }
}
