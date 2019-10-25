public class InitBoard { //puts pieces of the players on the board

    public static void init(Board board, Player p1, Player p2){
        // this short segment allows me to switch between inputs, order doesn't matter, black or white first
        Player whitePlayer;
        Player blackPlayer;
        if(p1.getPlayerColor() == PieceColor.WHITE &&
                p2.getPlayerColor()!= PieceColor.WHITE){
            whitePlayer = p1;
            blackPlayer = p2;
        } else {
            blackPlayer = p1;
            whitePlayer = p2;
        }

        //setup White pieces, works
        int a = 0;
        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                board.getBoard()[j][i].setPieceOnSquare(whitePlayer.getPieceSet().getPieceList()[a]);
                a++;
            }
        }

        //setup Black pieces, works

        int b = 0;
        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                board.getBoard()[7-j][7-i].setPieceOnSquare(blackPlayer.getPieceSet().getPieceList()[b]);
                b++;
            }
        }
    }
}
