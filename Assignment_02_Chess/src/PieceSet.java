public class PieceSet {
    private Piece[] list;
    private PieceColor coloredSet;

    public PieceSet(PieceColor coloredSet){
        this.coloredSet = coloredSet;
        if (coloredSet == PieceColor.WHITE){
            Piece a1 = new Rook(coloredSet);
            Piece h1 = new Rook(coloredSet);
            Piece b1 = new Knight(coloredSet);
            Piece g1 = new Knight(coloredSet);
            Piece c1 = new Bishop(coloredSet);
            Piece f1 = new Bishop(coloredSet);
            Piece d1 = new Queen(coloredSet);
            Piece e1 = new King(coloredSet);

            Piece a2 = new Pawn(coloredSet);
            Piece b2 = new Pawn(coloredSet);
            Piece c2 = new Pawn(coloredSet);
            Piece d2 = new Pawn(coloredSet);
            Piece e2 = new Pawn(coloredSet);
            Piece f2 = new Pawn(coloredSet);
            Piece g2 = new Pawn(coloredSet);
            Piece h2 = new Pawn(coloredSet);
            list = new Piece[]{a1, b1, c1, d1, e1, f1, g1, h1,
                    a2, b2, c2, d2, e2, f2, g2, h2};

        }
        else
        {
            Piece a8 = new Rook(coloredSet);
            Piece h8 = new Rook(coloredSet);
            Piece b8 = new Knight(coloredSet);
            Piece g8 = new Knight(coloredSet);
            Piece c8 = new Bishop(coloredSet);
            Piece f8 = new Bishop(coloredSet);
            Piece d8 = new Queen(coloredSet);
            Piece e8 = new King(coloredSet);

            Piece a7 = new Pawn(coloredSet);
            Piece b7 = new Pawn(coloredSet);
            Piece c7 = new Pawn(coloredSet);
            Piece d7 = new Pawn(coloredSet);
            Piece e7 = new Pawn(coloredSet);
            Piece f7 = new Pawn(coloredSet);
            Piece g7 = new Pawn(coloredSet);
            Piece h7 = new Pawn(coloredSet);
            list = new Piece[]{a8, b8, c8, d8, e8, f8, g8, h8,
                    a7, b7, c7, d7, e7, f7, g7, h7};
        }


    }


    public void setList(Piece[] list) {
        this.list = list;
    }
    /*
    public void removePiece(Piece capturedPiece){
        for(int i=0; i<16; i++){
            if(list[i] == capturedPiece){
                list[i] = null;
            }
        }
    }
*/
    public void setColoredSet(PieceColor coloredSet) { this.coloredSet = coloredSet; }

    public PieceColor getColoredSet() {
        return coloredSet;
    }

    public Piece[] getList(){
        return list;
    }
}

