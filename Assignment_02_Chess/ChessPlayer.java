public class ChessPlayer {
    private Pieces[] piecesEaten;
    private String playerName;


    public ChessPlayer(String inputName){ //Name Constructor
        playerName = inputName;
        piecesEaten = new Pieces[16];
    }


    public String getName(){ //Return Copy of Name: Design Principle Immutability
        return playerName;
    }




}