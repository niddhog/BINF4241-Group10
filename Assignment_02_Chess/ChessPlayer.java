public class ChessPlayer {
    private Pieces[] piecesEaten;
    private String playerName;
    private PieceColor color;


    public ChessPlayer(String inputName, PieceColor inputColor){ //Name Constructor
        playerName = inputName;
        color = inputColor;
        piecesEaten = new Pieces[16];
    }


    public String getName(){ //Return Copy of Name: Design Principle Immutability
        return playerName;
    }
    public PieceColor getColor() {return color; }



}