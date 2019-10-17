public class ChessBoard {
    private Square[][] squares = new Square[8][8]; //Matrix for holding 64 squares 8x8
    private Pieces[] pieceSets; //Array for storing PieceSets of Players (Black Set or White Set)
    private PieceColor pieceSetOnTop; //Which color plays on the Top Side of the Board

    public void create(){ //creates initial chess field and places Player 1 on top of the field
        for(int i = 0; i < squares.length; i++){
            for(int j = 0; j < squares.length; j++){
                squares[i][j] = new Square(i,j); //place all the squares at the right position in the board Grid
            }
        }
        switch (pieceSetOnTop){
            case BLACK: //Player 1 is Black

                break;
            case WHITE: //Player 1 is White

                break;
            default:
                System.out.println("Cannot setup Board, unspecified Player Color");
                break;
        }
    }
}

