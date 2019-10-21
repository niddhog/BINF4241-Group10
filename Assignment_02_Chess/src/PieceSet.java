public class PieceSet {
    private Piece[] list;
    private PieceColor coloredSet;

    public PieceSet(PieceColor coloredSet){
        this.coloredSet = coloredSet;

        Piece rook1 = new Rook(coloredSet);
        Piece rook2 = new Rook(coloredSet);
        Piece knight1 = new Knight(coloredSet);
        Piece knight2 = new Knight(coloredSet);
        Piece bishop1 = new Bishop(coloredSet);
        Piece bishop2 = new Bishop(coloredSet);
        Piece queen = new Queen(coloredSet);
        Piece king = new King(coloredSet);

        Piece pawn1 = new Pawn(coloredSet);
        Piece pawn2 = new Pawn(coloredSet);
        Piece pawn3 = new Pawn(coloredSet);
        Piece pawn4 = new Pawn(coloredSet);
        Piece pawn5 = new Pawn(coloredSet);
        Piece pawn6 = new Pawn(coloredSet);
        Piece pawn7 = new Pawn(coloredSet);
        Piece pawn8 = new Pawn(coloredSet);

        list = new Piece[]{rook1, rook2, knight1, knight2, bishop1, bishop2, queen, king,
                pawn1, pawn2, pawn3, pawn4, pawn5, pawn6, pawn7, pawn8};
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

