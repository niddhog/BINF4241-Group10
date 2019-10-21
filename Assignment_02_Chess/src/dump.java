public class dump {
           /* Stalemate isn´t necessary to implement, but it may be useful fot later on, for checkmate we already test the case
        otherwise with pieces specific methods

    public static boolean isStalemate(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Pieces checkedKing = new Pieces;
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j] == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }

        if(attackingSet.getColoredSet() == currentPlayer.getColor()){
            for(int i=0; i<16;i++){
                if(attackingSet.getList()[i].validMoves() != checkedKing.placeAt() && attackingSet.getList()[i].toBeCaptured()==false
                    && checkedKing.captureFreeMoves()==null){
                    checkedKing.inCheck()=false;
                }
            }
        }
    }
    */
}
