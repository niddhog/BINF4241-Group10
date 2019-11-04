public class Square implements Observer {
    private int xCo;
    private int yCo;
    private Piece pieceOnSquare = null;

    public Square(int x, int y){
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
    public void update(int xStart, int yStart, int xEnd, int yEnd, Piece movedPiece) {
        if(this.xCo == xStart && this.yCo == yStart){
            deletePieceOnSquare();
        }
        else if(this.xCo == xEnd && this.yCo == yEnd){
            setPieceOnSquare(movedPiece);
            movedPiece.setMoved();
        }
        else{

        }
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
