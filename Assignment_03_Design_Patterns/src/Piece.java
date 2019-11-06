
abstract public class Piece implements PieceInterface
{
    private String pieceName;
    private PieceColor pieceColor;
    private PieceType pieceType;
    public boolean moved = false;

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public void setMoved() {
        this.moved = true;
    }

    public String getPieceName() {
        return pieceName;
    }


    public void setPieceType(PieceType pieceType)
    {
        this.pieceType = pieceType;
    }

    public void setPieceColor(PieceColor pieceColor)
    {
        this.pieceColor = pieceColor;
    }

    public PieceColor getPieceColor()
    {
        return pieceColor;
    }

    public PieceType getPieceType(){return pieceType;}

    static boolean isDiagonal(int xfrom, int yfrom, int xto, int yto) {
        // A move is diagonal if abs(dx) == abs(dy)... I think
        return (Math.abs(xto - xfrom) == Math.abs(yto - yfrom));
    }

    static boolean isVerticalOrHorizontal(int xfrom, int yfrom, int xto, int yto) {
        // Either only y changes, or only x changes.
        return ((xfrom == xto && yfrom != yto) || (yfrom == yto && xfrom != xto));
    }

    public String giveWorBAccordingToColor(PieceColor color){
        if(color == PieceColor.BLACK){
            return "B";
        } else {
            return "W";

        }

    }

    public abstract boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture);
};

class Rook extends Piece
{
    Rook(PieceColor color)
    {
        setPieceName(giveWorBAccordingToColor(color)+"R");
        setPieceColor(color);
        setPieceType(PieceType.ROOK);

    }
    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return isVerticalOrHorizontal(xfrom, yfrom, xto, yto);
    }
};

class Knight extends Piece implements KnightPiece
{
    Knight(PieceColor color )
    {
        setPieceName(giveWorBAccordingToColor(color)+"H");
        setPieceColor(color);
        setPieceType(PieceType.KNIGHT);
    }

    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return ((Math.abs(xfrom - xto) == 1 && Math.abs(yfrom - yto) == 2) ||
                (Math.abs(yfrom - yto) == 1 && Math.abs(xfrom - xto) == 2));
    }
    // fuck Castling is missing
};

class   Bishop extends Piece implements BishopPiece
{
    Bishop(PieceColor color)
    {
        setPieceName(giveWorBAccordingToColor(color)+"B");
        setPieceColor(color);
        setPieceType(PieceType.BISHOP);
    }

    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return isDiagonal(xfrom, yfrom, xto, yto);
    }

}
class Queen extends Piece implements QueenPiece
{
    Queen(PieceColor color )
    {
        setPieceName(giveWorBAccordingToColor(color)+"Q");
        setPieceColor(color);
        setPieceType(PieceType.QUEEN);
    }
    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return (isDiagonal(xfrom, yfrom, xto, yto) || isVerticalOrHorizontal(xfrom, yfrom, xto, yto));
    }
}

class King extends Piece
{
    King(PieceColor color)
    {
        setPieceName(giveWorBAccordingToColor(color)+"K");
        setPieceColor(color);
        setPieceType(PieceType.KING);
    }
    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return (Math.abs(xfrom - xto) <= 1 && Math.abs(yfrom - yto) <= 1);
    }
};


class Pawn extends Piece
{
    Pawn(PieceColor color)
    {
        setPieceName(giveWorBAccordingToColor(color)+"P");
        setPieceColor(color);
        setPieceType(PieceType.PAWN);

    }

    public boolean promoted;
    public Piece promotedTo;

    @Override
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture) {
        return (this.moveDirection(yfrom, yto) &&
                (!(this.moved) ?
                        ((Math.abs(yto - yfrom) == 2) ||
                                Math.abs(yto - yfrom) == 1) :
                        (Math.abs(yto-yfrom) == 1)) &&
                ((capture &&
                        Math.abs(xto - xfrom) == 1 &&
                        Math.abs(yto-yfrom) == 1) ||
                        (!capture && xfrom == xto)));
    }

    private boolean moveDirection(int yfrom, int yto)
    {
        return (getPieceColor() == PieceColor.WHITE) ? (yfrom <= yto) : (yto <= yfrom);
    };
};




