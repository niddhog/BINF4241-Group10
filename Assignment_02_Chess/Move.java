import java.util.Scanner;

public class Move {
    private ChessPlayer player;
    private Square start;
    private Square end;
    private boolean castlingMove = false;
    private Pieces[] enemyList;
    private Pieces[] pieceList;

    public void Move(ChessPlayer player, Square start, Square end) {
        this.player = player;
        this.start = start;
        this.end = end;


        //one list is from the current player and the other one for the case, when a piece captured
        if (player.getColor() == PieceColor.BLACK) {
            enemy = PieceColor.WHITE;
            if (PieceSet.getColor() == PieceColor.BLACK)
                pieceList = PieceSet.getList();
            if (PieceSet.getColor() == PieceColor.WHITE) {
                enemyList = PieceSet.getList();
            }
        } else {
            enemy = PieceColor.BLACK;
            if (PieceSet.getColor() == PieceColor.WHITE)
                pieceList = PieceSet.getList();
            if (PieceSet.getColor() == PieceColor.BLACK) {
                enemyList = PieceSet.getList();
            }
        }

            for (int i = 0; i < 16; i++) {                    //todo final name of the PieceList
                //idea search for the piece on the square
                //capture enemy's piece, if it's occupied
                if (pieceList[i] != null && pieceList[i].placeAt == start) {
                    if (pieceList[i].validMove() == end && pieceList[i].attackSquares() == end) {
                        for(int a=0;a<16; a++){
                            if(enemyList[i].placeAt() == end){
                                enemyList[i].toBeCaptured() = true;
                            }
                            pieceList[i].placeAt = end;
                        }
                    }
                    else if(pieceList[i].validMove() == end && pieceList[i].captureFreeMoves() == end){
                        pieceList[i].placeAt = end;

                    }
                }
                else{
                    Scanner nameObject = new Scanner(System.in);
                    Move(player, );
                }
            }


    }

    public boolean isCastlingMove()
    {
        return this.castlingMove == true;
    }

    public void setCastlingMove(boolean castlingMove)
    {
        this.castlingMove = castlingMove;
    }


}
