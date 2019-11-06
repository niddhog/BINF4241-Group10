public class Archbishop extends Piece{
    BishopPiece bishop;
    KnightPiece knight;

    public Archbishop(BishopPiece bishop, KnightPiece knight){
        this.bishop=bishop;
        this.knight=knight;
        setPieceName(giveWorBAccordingToColor(bishop.getPieceColor())+"B");
        setPieceColor(bishop.getPieceColor());
        setPieceType(PieceType.ARCHBISHOP);
    }

    public String giveWorBAccordingToColor(PieceColor color){
        if(color == PieceColor.BLACK){
            return "B";
        } else {
            return "W";
        }
    }

    public void setPieceName(String pieceName) {
        bishop.setPieceName(pieceName);
    }

    public void setMoved() {
        bishop.setMoved();
    }

    public String getPieceName() {
        return bishop.getPieceName(); }


    public void setPieceType(PieceType pieceType)
    {
        bishop.setPieceType(pieceType);
    }

    public void setPieceColor(PieceColor pieceColor)
    {
        bishop.setPieceColor(pieceColor);
    }

    public PieceColor getPieceColor()
    {
        return bishop.getPieceColor();
    }

    public PieceType getPieceType(){return bishop.getPieceType();}

    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture) {
        if(bishop.validMove(xfrom, yfrom, xto, yto, capture) || knight.validMove(xfrom, yfrom, xto, yto, capture)){
            return true;
        }
        else{
            return false;
        }
    }
}
