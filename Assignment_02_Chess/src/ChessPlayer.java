public class ChessPlayer {
    private Piece[] piecesEaten; //todo is piecesEaten necessary? because toBeCaptured() is false(alive) or true(dead)
    private String playerName;
    private PieceColor color;


    public ChessPlayer(String inputName, PieceColor inputColor){ //Name Constructor
        playerName = inputName;
        color = inputColor;
        piecesEaten = new Piece[16];
    }


    public String getName(){ //Return Copy of Name: Design Principle Immutability
        return playerName;
    }
    public PieceColor getColor() {return color; }
    public Piece[] getPiecesEaten(){return piecesEaten;}


    //setter for the eaten pieces

    public Piece[] setPiecesEaten(PieceSet.getList() capturedPiece, int a){
        int i = 0;
        while(piecesEaten[i]!=null){
            i++;
        }
        piecesEaten[i]=capturedPiece[a];
    }



}