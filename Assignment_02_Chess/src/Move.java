public class Move {
    private ChessPlayer player;
    private Square start;
    private Square end;
    private boolean castlingMove = false;
    private PieceSet blackSet;
    private PieceSet whiteSet;
    private Piece[] enemyList;
    private Piece[] pieceList;



    public Move(ChessPlayer player, Square start, Square end, PieceSet blackSet, PieceSet whiteSet, ChessBoard board) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.blackSet=blackSet;
        this.whiteSet=whiteSet;



        //one list is from the current player and the other one for the case, when a piece captured
        if (player.getColor() == PieceColor.BLACK) {
                pieceList = blackSet.getList();
                enemyList = whiteSet.getList();
            }
        else {
                pieceList = whiteSet.getList();
                enemyList = blackSet.getList();
            }

        if(board.getSquare(0, 4)==start) {
            if (end == board.getSquare(0, 2) && isCastlingMove(blackSet, whiteSet, board, player)) {
                for (int i = 0; i < 16; i++) {
                    if (pieceList[i] == PieceType.King) {
                        pieceList[i].getPlaceAt() == end;
                    }
                }
                for (int j = 0; j < 16; j++) {
                    if (pieceList[j] == PieceType.Rook && pieceList[j].getPlaceAt()== board.getSquare(0,0)) {
                        pieceList[j].setPlaceAt(board.getSquare(0,3));
                    }
                }
            }
            else if (end == board.getSquare(0, 6) && isCastlingMove(blackSet, whiteSet, board, player)) {
                for (int i = 0; i < 16; i++) {
                    if (pieceList[i] == PieceType.King) {
                        pieceList[i].getPlaceAt() = end;
                    }
                }
                for (int j = 0; j < 16; j++) {
                    if (pieceList[j] == PieceType.Rook && pieceList[j].getPlaceAt()== board.getSquare(0,7)) {
                        pieceList[j].getPlaceAt() = board.getSquare(0,5);
                    }
                }
            }
        }
        else if (board.getSquare(7, 4)==start){
            if (end == board.getSquare(7, 2) && isCastlingMove(blackSet, whiteSet, board, player)) {
                for (int i = 0; i < 16; i++) {
                    if (pieceList[i] == PieceType.King) {
                        pieceList[i].getPlaceAt() = end;
                    }
                }
                for (int j = 0; j < 16; j++) {
                    if (pieceList[j] == PieceType.Rook && pieceList[j].getPlaceAt()== board.getSquare(7,0)) {
                        pieceList[j].getPlaceAt() = board.getSquare(7,3);
                    }
                }
            }
            else if (end == board.getSquare(7, 6) && isCastlingMove(blackSet, whiteSet, board, player)) {
                for (int i = 0; i < 16; i++) {
                    if (pieceList[i] == PieceType.King) {
                        pieceList[i].getPlaceAt() = end;
                    }
                }
                for (int j = 0; j < 16; j++) {
                    if (pieceList[j] == PieceType.Rook && pieceList[j].getPlaceAt()== board.getSquare(7,7)) {
                        pieceList[j].getPlaceAt() = board.getSquare(7,5);
                    }
                }
            }
        }
        


            //searching, if any of player's piece is on this square, it's chosen to be moved
            //afterwards, it tests, if the move is valid and if there's a piece to capture


            for (int i = 0; i < 16; i++) {                    //todo final name of the PieceList
                //idea search for the piece on the square
                //capture enemy's piece, if it's occupied
                if (pieceList[i].toBeCaptured()==false && pieceList[i].getPlaceAt() == start) {
                    if (pieceList[i].validMove() == end && pieceList[i].attackSquares() == end) {
                        for(int a=0;a<16; a++){
                            if(enemyList[i].getPlaceAt() == end){
                                enemyList[i].toBeCaptured() = true; //note, the piece won't be deleted within the list, only set true for captured
                            }                                       //todo if you want to add the captured pieces to pieceEaten[] we have to return i for setPieceEaten()
                            pieceList[i].getPlaceAt() = end;
                        }
                    }
                    else if(pieceList[i].validMove() == end && pieceList[i].captureFreeMoves() == end){
                        pieceList[i].getPlaceAt() = end;
                    }
                }
            }
    }


    // suppose firstMove() is a boolean for the king and the rooks, if they already moved, they can't castling
    //4 situations castling White king Queen side, castling white king king side, castling black king queen side
    //castling black king king side
    public static boolean isCastlingMove(PieceSet pieceSet1, PieceSet pieceSet2, ChessBoard board, ChessPlayer currentPlayer)
        {

        boolean king = false;
        boolean qRook = false;
        boolean kRook = false;
        boolean possible;
        possible=false;
        PieceSet set1 = new PieceSet(pieceSet1.getColoredSet());
        PieceSet set2 = new PieceSet(pieceSet2.getColoredSet());
        PieceSet temp = new PieceSet(currentPlayer.getColor());
        if (set1 != temp) {
            set2 = set1;
            set1 = temp;
        }
            Piece castlingKing = new King(set1.getColoredSet());
            Piece QRook = new Rook(set1.getColoredSet());
            Piece KRook = new Rook(set1.getColoredSet());


        //topside pieceSet
        for (int a = 0; a < 16; a++) {
            if (set1.getList()[a] == PieceType.King && set1.getList()[a].getPlaceAt() == board.getSquare(0, 4)
                    && set1.getList()[a].firstMove() == false && set1.getList()[a].inCheck() == false) {
                castlingKing = set1.getList()[a];
                king = true;
            }
            else{
                possible=false;
            }
        }

        for (int b = 0; b < 16; b++) {
            if (set1.getList()[b] == PieceType.Rook && set1.getList()[b].firstMove() == false
                    && set1.getList()[b].getPlaceAt() == board.getSquare(0, 0)) {
                QRook = set1.getList()[b];
                qRook = true;
            }
            else{
                possible=false;
            }
        }

        for (int b = 0; b < 16; b++) {
            if (set1.getList()[b] == PieceType.Rook && set1.getList()[b].firstMove() == false
                    && set1.getList()[b].getPlaceAt() == board.getSquare(0, 7)) {
                KRook = set1.getList()[b];
                kRook = true;
            }
            else{
                possible=false;
            }
        }




        //bottom side pieceSet
        for (int a = 0; a < 16; a++) {
            if (set1.getList()[a] == PieceType.King && set1.getList()[a].getPlaceAt() == board.getSquare(7, 4)
                    && set1.getList()[a].firstMove() == false && set1.getList()[a].inCheck() == false) {
                castlingKing = set1.getList()[a];
                king = true;
            }
            else{
                possible=false;
            }
        }
        

        for (int b = 0; b < 16; b++) {
            if (set1.getList()[b] == PieceType.Rook && set1.getList()[b].firstMove() == false
                    && set1.getList()[b].getPlaceAt() == board.getSquare(7, 0)) {
                QRook = set1.getList()[b];
                qRook = true;
            }
            else{
                possible=false;
            }
        }

        for (int b = 0; b < 16; b++) {
            if (set1.getList()[b] == PieceType.Rook && set1.getList()[b].firstMove() == false
                    && set1.getList()[b].getPlaceAt() == board.getSquare(7, 7)) {
                KRook = set1.getList()[b];
                kRook = true;
            }
            else{
                possible=false;;
            }
        }


        if(qRook && king){
        // queen side check, no (of my/their) pieces are placed AND opponents attackSquares() can´t reach these squares
            for(int i =0 ; i<16; i++){
                if(set1.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-1)
                    || set1.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-2)
                    || set2.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-1)
                    || set2.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-2)
                    || set2.getList()[i].attackSquares() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-1)
                    || set2.getList()[i].attackSquares() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY()-2))
                { 
                    possible=false;;
            }
                else{
                    possible=true;
                }
            }
        }

        if(kRook && king) {
            // king side check, no (of my/their) pieces are placed AND opponents attackSquares() can´t reach these squares
            for (int i = 0; i < 16; i++) {
                if (set1.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY() + 1)
                        || set1.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY() + 2)
                        || set2.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY() + 1)
                        || set2.getList()[i].getPlaceAt() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY() + 2)
                        || set2.getList()[i].attackSquares() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt().getY() + 1)
                        || set2.getList()[i].attackSquares() == board.getSquare(castlingKing.getPlaceAt().getX(), castlingKing.getPlaceAt() .getY() + 2))
                {
                    possible=false;;
                }
            }

            }
        else{
            possible=true;
        }
        if(possible){
            return true;
        } 
        else{
            return false;
        }
        }
}

    

