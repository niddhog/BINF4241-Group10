public class Move {

    public static void move(Board gameBoard, Coordinates s, Coordinates e) {
        Piece movedPiece = gameBoard.getBoard()[s.getX()][s.getY()].getPieceOnSquare();
        gameBoard.getBoard()[s.getX()][s.getY()].deletePieceOnSquare();
        gameBoard.getBoard()[e.getX()][e.getY()].setPieceOnSquare(movedPiece);
        movedPiece.setMoved();
    }
}
