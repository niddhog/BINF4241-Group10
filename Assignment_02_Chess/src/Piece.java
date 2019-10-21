
public class Piece
{
    private PieceColor pieceColor;
    private Square placeAt;
    private boolean moved;
    private PieceType pieceType;

    public boolean firstMove = true;

    public void setPieceType(PieceType pieceType)
    {
        this.pieceType = pieceType;
    }

    public void setPieceColor(PieceColor pieceColor)
    {
        this.pieceColor = pieceColor;
    }

    public Square getPlaceAt()
    {
        return placeAt;
    };

    public void setPlaceAt(Square placeAt) { this.placeAt = placeAt;}

    public PieceColor getPieceColor()
    {
        return pieceColor;
    }

    static boolean isDiagonal(int xfrom, int yfrom, int xto, int yto) {
        // A move is diagonal if abs(dx) == abs(dy)... I think
        return (Math.abs(xto - xfrom) == Math.abs(yto - yfrom));
    }

    static boolean isVerticalOrHorizontal(int xfrom, int yfrom, int xto, int yto) {
        // Either only y changes, or only x changes.
        return ((xfrom == xto && yfrom != yto) || (yfrom == yto && xfrom != xto));
    }
};

class Rook extends Piece
{
    Rook(PieceColor color)
    {
        setPieceColor(color);
        setPieceType(PieceType.ROOK);

    }

    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return isVerticalOrHorizontal(xfrom, yfrom, xto, yto);
    }
};

class Knight extends Piece
{
    Knight(PieceColor color )
    {
        setPieceColor(color);
        setPieceType(PieceType.KNIGHT);
    }

    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return ((Math.abs(xfrom - xto) == 1 && Math.abs(yfrom - yto) == 2) ||
                (Math.abs(yfrom - yto) == 1 && Math.abs(xfrom - xto) == 2));
    }
    // fuck Castling is missing
};

class Bishop extends Piece
{
    Bishop(PieceColor color )
    {
        setPieceColor(color);
        setPieceType(PieceType.BISHOP);
    }


    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return isDiagonal(xfrom, yfrom, xto, yto);
    }

}
class Queen extends Piece
{
    Queen(PieceColor color )
    {
        setPieceColor(color);
        setPieceType(PieceType.QUEEN);
    }

    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return (isDiagonal(xfrom, yfrom, xto, yto) || isVerticalOrHorizontal(xfrom, yfrom, xto, yto));
    }
}

class King extends Piece
{
    King(PieceColor color)
    {
        setPieceColor(color);
        setPieceType(PieceType.KING);
    }

    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture)
    {
        return (Math.abs(xfrom - xto) <= 1 && Math.abs(yfrom - yto) <= 1);
    }
};


class Pawn extends Piece
{
    Pawn(PieceColor color)
    {
        setPieceColor(color);
        setPieceType(PieceType.PAWN);

    }

    public boolean promoted;
    public Piece promotedTo;


    boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture) {
        //fuck this pawn shit.
        return (this.moveDirection(yfrom, yto) &&
                ((this.firstMove) ?
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




