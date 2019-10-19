import java.util.Scanner;

public class Move {
    private ChessPlayer player;
    private Square start;
    private Square end;
    private boolean castlingMove = false;
    private PieceSet blackSet;
    private PieceSet whiteSet;
    private Pieces[] enemyList;
    private Pieces[] pieceList;
    private PieceSet[] pieceSet1;
    private PieceSet[] pieceSet2;
    private PieceSet[] set1;
    private PieceSet[] set2;

    public Square getStart(){
        return start;
    }
    public Square getEnd(){
        return end;
    }


    public Move(ChessPlayer player, Square start, Square end, PieceSet blackSet, PieceSet whiteSet) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.blackSet=blackSet;
        this.whiteSet=whiteSet;
        PieceColor enemy;


        //one list is from the current player and the other one for the case, when a piece captured
        if (player.getColor() == PieceColor.BLACK) {
            enemy = PieceColor.WHITE;
                pieceList = blackSet.getList();
                enemyList = whiteSet.getList();
            }
        else {
            enemy = PieceColor.BLACK;
                pieceList = whiteSet.getList();
                enemyList = blackSet.getList();
            }


            //searching, if any of player's piece is on this square, it's chosen to be moved
            //afterwards, it tests, if the move is valid and if there's a piece to capture


            for (int i = 0; i < 16; i++) {                    //todo final name of the PieceList
                //idea search for the piece on the square
                //capture enemy's piece, if it's occupied
                if (pieceList[i].toBeCaptured()==false && pieceList[i].placeAt == start) {
                    if (pieceList[i].validMove() == end && pieceList[i].attackSquares() == end) {
                        for(int a=0;a<16; a++){
                            if(enemyList[i].placeAt() == end){
                                enemyList[i].toBeCaptured() = true; //note, the piece won't be deleted within the list, only set true for captured
                            }                                       //todo if you want to add the captured pieces to pieceEaten[] we have to return i for setPieceEaten()
                            pieceList[i].placeAt() = end;
                        }
                    }
                    else if(pieceList[i].validMove() == end && pieceList[i].captureFreeMoves() == end){
                        pieceList[i].placeAt() = end;
                    }
                }
            }
    }


    // suppose firstMove() is a boolean for the king and the rooks, if they already moved, they can't castling
    //4 situations castling White king Queen side, castling white king king side, castling black king queen side
    //castling black king king side
    public boolean isCastlingMove(PieceSet pieceSet1, PieceSet pieceSet2, ChessBoard board, ChessPlayer currentPlayer) {
        if(pieceSet1.getColoredSet()==currentPlayer.getColor()){
            PieceSet set1 = new PieceSet(pieceSet1.getColoredSet());
            set1=pieceSet1;
            PieceSet set2 = new PieceSet(pieceSet2.getColoredSet());
            set2 = pieceSet2;
        }
        else{
            PieceSet set2 = new PieceSet(pieceSet1.getColoredSet());
            set2=pieceSet1;
            PieceSet set1 = new PieceSet(pieceSet2.getColoredSet());
            set1 = pieceSet2;
        }
        for(int a=0; a<16; a++) {
            if (set1.getList()[a] == PieceType.King && set1.getList()[a].placeAt() == board.getSquare(0, 5)
                    && set1.getList()[a].firstMove() == false && set1.getList()[a] == PieceType.Rook &&
                    set1.getList()[a].firstMove() == false && set1.getList()[a].placeAt() == board.getSquare(0, 0)
                    && set1.getList()[a].inCheck() == false) {

            } else if (set1.getList()[a] == PieceType.King && set1.getList()[a].placeAt() == board.getSquare(7, 5)
                    && set1.getList()[a].firstMove() == false && set1.getList()[a] == PieceType.Rook &&
                    set1.getList()[a].firstMove() == false && set1.getList()[a].placeAt() == board.getSquare(7, 0)
                    && set1.getList()[a].inCheck() == false) {

            }
        }
            else if{
                for(int a=0; a<16; a++){
                    if(set1.getList()[a] == PieceType.King && set1.getList()[a].placeAt() == board.getSquare(0, 5)
                            && set1.getList()[a].firstMove() == false &&
                            && set1.getList()[a].inCheck() == false ){
                for(int b=0; a<16; b++)
                    if (set1.getList()[a] == PieceType.Rook &&
                        set1.getList()[a].firstMove() == false && set1.getList()[a].placeAt() == board.getSquare(0, 7)
            }
        }
    }
}

