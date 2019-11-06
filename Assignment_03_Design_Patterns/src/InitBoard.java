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

        PieceSet blackSet = new PieceSet(blackPlayer.getPlayerColor());
        PieceSet whiteSet = new PieceSet(whitePlayer.getPlayerColor());

        Iterator blackIterator = blackSet.createIterator();
        Iterator whiteIterator = whiteSet.createIterator();

        //setup White pieces, works
        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                if (whiteIterator.hasNext()) {
                    board.getBoard()[j][i].setPieceOnSquare(whiteIterator.next());
                }
            }
        }

        //setup Black pieces, works

        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                if(blackIterator.hasNext()) {
                    board.getBoard()[7 - j][7 - i].setPieceOnSquare(blackIterator.next());
                }
            }
        }
    }
}
