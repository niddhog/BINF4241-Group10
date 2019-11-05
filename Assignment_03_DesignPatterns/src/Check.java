public class Check {
    private Piece varPieces;
    private Move move;
    private Coordinates kingPos = new Coordinates("a1"); // quick fix :(

    public Check(Move move, Board board){
        this.move = move;
    }

    boolean isCheck(Board board, Player currPlayer){
        Iterator kingIterator = board.createIterator();
        Iterator attackIterator = board.createIterator();
        Coordinates varPos = new Coordinates("a1");
        PieceColor currColor = currPlayer.getPlayerColor();
        boolean isCheck = false;

        // finds King of the current player
        while(kingIterator.hasNext()){
            Square square = (Square) kingIterator.next();
            varPieces = square.getPieceOnSquare();
            if(varPieces != null){
                if(varPieces.getPieceType() == PieceType.KING && currColor == varPieces.getPieceColor()){
                    kingPos.setX(square.getX()); kingPos.setY(square.getY());
                    break;
                }
            }
        }

        // finds attacking pieces of enemy player
        while(attackIterator.hasNext()){
            Square square = (Square) attackIterator.next();
            varPieces = square.getPieceOnSquare();
            if(varPieces != null){
                if(varPieces.getPieceColor() != currColor){
                    varPos.setX(square.getX()); varPos.setY(square.getY());
                    if(varPieces.validMove(square.getX(), square.getY(), kingPos.getX(), kingPos.getY(), true) &&
                            !board.isSomethingBetween(varPieces, varPos, kingPos)){
                        isCheck = true;
                        break;
                    }
                }
            }
        }
        return isCheck;
    }


    public boolean isMate(Board board, Player currPlayer) { //mate doesnt work as intended
        Iterator mateIterator = board.createIterator();
        boolean isMate = false;
        Board copy;

        while(mateIterator.hasNext()){
            Square square = (Square) mateIterator.next();
            copy = copyBoard(board);
            Coordinates varPos = new Coordinates("a1");
            varPos.setX(square.getX()); varPos.setY(square.getY());
            if(copy.getBoard()[kingPos.getX()][kingPos.getY()].getPieceOnSquare() != null){
                if(copy.getBoard()[kingPos.getX()][kingPos.getY()]
                        .getPieceOnSquare().validMove(kingPos.getX(), kingPos.getY(), square.getX(), square.getY(), true)){
                    if(!copy.isSomethingBetween(copy.getBoard()[kingPos.getX()][kingPos.getY()].getPieceOnSquare(), kingPos, varPos)){
                        move.move(copy, kingPos, varPos);
                        if(!isCheck(copy, currPlayer)){
                            break;
                        }
                    }
                }
            }
        }
        return isMate;
    }


    private Board copyBoard(Board board){
        Iterator copyIterator = board.createIterator();
        Piece copyPiece;
        Board copy = new Board(move);

        while(copyIterator.hasNext()){
            Square square = (Square) copyIterator.next();
            if(board.getBoard()[square.getX()][square.getY()].getPieceOnSquare() !=null){
                copyPiece = board.getBoard()[square.getX()][square.getY()].getPieceOnSquare();
                copy.getBoard()[square.getX()][square.getY()].setPieceOnSquare(copyPiece);
            }
        }
        return copy;
    }
}

