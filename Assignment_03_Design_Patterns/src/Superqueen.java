public class Superqueen extends Piece implements PieceInterface{
    QueenPiece queen;




    public Superqueen(QueenPiece queen)
    {
        this.queen=queen;
        setPieceName(giveWorBAccordingToColor(queen.getPieceColor())+"Q");
        setPieceColor(queen.getPieceColor());
        setPieceType(PieceType.SUPERQUEEN);
    }

    public String giveWorBAccordingToColor(PieceColor color){
        if(color == PieceColor.BLACK){
            return "B";
        } else {
            return "W";

        }

    }

    public void setPieceName(String pieceName) {
        queen.setPieceName(pieceName);
    }

    public void setMoved() {
        queen.setMoved();
    }

    public String getPieceName() {
        return queen.getPieceName(); }


    public void setPieceType(PieceType pieceType)
    {
        queen.setPieceType(pieceType);
    }

    public void setPieceColor(PieceColor pieceColor)
    {
        queen.setPieceColor(pieceColor);
    }

    public PieceColor getPieceColor()
    {
        return queen.getPieceColor();
    }

    public PieceType getPieceType(){return queen.getPieceType();}

    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture) {
        if(queen.validMove(xfrom, yfrom, xto, yto, capture)
                /*|| teleport(xto, yto, board, capture)
                */
                ){

            return true;
        }
        else{
            return false;
        }
    }

    /*
    public boolean teleport(int xto, int yto, BoardInterface board, boolean capture){
        if(board.getBoard()[xto][yto].getPieceOnSquare()==null) {
            return true;
        }
        else {
            return false;
        }
    }

     */
}
