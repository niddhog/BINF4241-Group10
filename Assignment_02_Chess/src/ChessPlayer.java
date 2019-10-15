public class ChessPlayer {
    private Pieces[] piecesEaten;
    private String playerName;
    private String color;


    public ChessPlayer(String inputName, String inputColor){ //Name Constructor
        playerName = inputName;
        color = inputColor;
        piecesEaten = new Pieces[16];
    }


    public String getName(){ //Return Copy of Name: Design Principle Immutability
        return playerName;
    }
    public String getColor() {return color; }



}