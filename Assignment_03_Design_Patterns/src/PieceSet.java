public class PieceSet {
    private Piece[] pieceList;
    private PieceColor setColor;

    public PieceSet(PieceColor color){
        this.setColor = color;
        if (color == PieceColor.WHITE){
            Piece a1 = new Rook(color);
            Piece h1 = new Rook(color);
            Piece b1 = new Knight(color);
            Piece g1 = new Knight(color);
            Bishop sampleBishop = new Bishop(color);
            Knight sampleKnight = new Knight(color);
            Piece c1 = new Archbishop(sampleBishop, sampleKnight);
            Piece f1 = new Archbishop(sampleBishop, sampleKnight);
            Queen sampleQueen = new Queen(color);
            Piece d1 = new Superqueen(sampleQueen);
            Piece e1 = new King(color);

            Piece a2 = new Pawn(color);
            Piece b2 = new Pawn(color);
            Piece c2 = new Pawn(color);
            Piece d2 = new Pawn(color);
            Piece e2 = new Pawn(color);
            Piece f2 = new Pawn(color);
            Piece g2 = new Pawn(color);
            Piece h2 = new Pawn(color);
            pieceList = new Piece[]{a1, b1, c1, d1, e1, f1, g1, h1,
                    a2, b2, c2, d2, e2, f2, g2, h2};

        }
        else
        {
            Piece a8 = new Rook(color);
            Piece h8 = new Rook(color);
            Piece b8 = new Knight(color);
            Piece g8 = new Knight(color);
            Piece c8 = new Bishop(color);
            Piece f8 = new Bishop(color);
            Piece e8 = new Queen(color);
            Piece d8 = new King(color);

            Piece a7 = new Pawn(color);
            Piece b7 = new Pawn(color);
            Piece c7 = new Pawn(color);
            Piece d7 = new Pawn(color);
            Piece e7 = new Pawn(color);
            Piece f7 = new Pawn(color);
            Piece g7 = new Pawn(color);
            Piece h7 = new Pawn(color);
            pieceList = new Piece[]{a8, b8, c8, d8, e8, f8, g8, h8,
                    a7, b7, c7, d7, e7, f7, g7, h7};
        }


    }


    public void setPieceList(Piece[] pieceList) {
        this.pieceList = pieceList;
    }

    public PieceColor getSetColor() {
        return setColor;
    }

    public Piece[] getPieceList(){
        return pieceList;
    }

    public Iterator createIterator(){
        return new setIterator(pieceList);
    }
}

