public class Check {
    Piece varPieces;
    Coordinates kingPos = new Coordinates("a1"); // quick fix :(


    boolean isCheck(Board board, Player currPlayer){
        Coordinates varPos = new Coordinates("a1");
        PieceColor currColor = currPlayer.getPlayerColor();
        boolean isCheck = false;

        // finds King of the current player
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                varPieces = board.getBoard()[i][j].getPieceOnSquare();
                if(varPieces != null){
                    if(varPieces.getPieceType() == PieceType.KING && currColor == varPieces.getPieceColor()){
                        kingPos.setX(i); kingPos.setY(j);
                        break;
                    }
                }
            }
        }

        // finds attacking pieces of enemy player
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                varPieces = board.getBoard()[i][j].getPieceOnSquare();
                if(varPieces != null){
                    if(varPieces.getPieceColor() != currColor){
                        varPos.setX(i); varPos.setY(j);
                        if(varPieces.validMove(i, j, kingPos.getX(), kingPos.getY(), true) &&
                                !board.isSomethingBetween(varPieces, varPos, kingPos)){
                            isCheck = true;
                            break;
                        }
                    }
                }
            }
        }
        return isCheck;
    }

    public boolean isMate(Board board, Player currPlayer) { //mate doesnt work as intended

        boolean isMate = false;
        Board copy;

        if(isCheck(board, currPlayer)){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++) {
                    copy = copyBoard(board);
                    Coordinates varPos = new Coordinates("a1");
                    varPos.setX(i); varPos.setY(j);
                    if(copy.getBoard()[kingPos.getX()][kingPos.getY()].getPieceOnSquare() != null){
                        if(copy.getBoard()[kingPos.getX()][kingPos.getY()]
                                .getPieceOnSquare().validMove(kingPos.getX(), kingPos.getY(), i, j, true)){
                            if(!copy.isSomethingBetween(copy.getBoard()[kingPos.getX()][kingPos.getY()].getPieceOnSquare(), kingPos, varPos)){
                                Move.move(copy, kingPos, varPos);
                                if(!isCheck(copy, currPlayer)){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            isMate = true;
        }
        return isMate;
    }

    public Board copyBoard(Board board){
        Piece copyPiece;
        Board copy = new Board();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(board.getBoard()[i][j].getPieceOnSquare() !=null){
                    copyPiece = board.getBoard()[i][j].getPieceOnSquare();
                    copy.getBoard()[i][j].setPieceOnSquare(copyPiece);
                }
            }
        }
        return copy;
    }
}

