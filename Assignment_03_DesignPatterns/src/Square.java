public class Square {
    private int xCo;
    private int yCo;
    private Piece pieceOnSquare = null;

    Square(int x, int y){
        xCo = x;
        yCo = y;
    }

    public int getY() {
        return yCo;
    }

    public int getX() {
        return xCo;
    }

    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
    }

    public void deletePieceOnSquare(){
        this.setPieceOnSquare(null);
    }

    @Override
    public String toString() {
        if(getPieceOnSquare() == null){
            return "[  ]";
        } else{
            return "[" + getPieceOnSquare().getPieceName() + "]";
        }
    }
}
