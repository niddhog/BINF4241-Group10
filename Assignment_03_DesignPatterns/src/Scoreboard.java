public class Scoreboard {
    private static Scoreboard uniqueInstance;
    private static int whiteScore = 0;
    private static int blackScore = 0;

    private Scoreboard(){}

    public static Scoreboard getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Scoreboard();
        }
        return uniqueInstance;
    }


    public void updateScoreBoard(Piece pieceKilled){
        if(pieceKilled.getPieceColor() == PieceColor.WHITE){
            if(pieceKilled.getPieceType() == PieceType.QUEEN){
                whiteScore += 5;
            }
            else{
                whiteScore ++;
            }
        }
        else{
            if(pieceKilled.getPieceType() == PieceType.QUEEN){
                blackScore += 5;
            }
            else{
                blackScore ++;
            }
        }
    }


    @Override
    public String toString(){
        return "<White Player Score: " + whiteScore + ">" + "\n" + "<Black Player Score: " + blackScore + ">\n";
    }
}
