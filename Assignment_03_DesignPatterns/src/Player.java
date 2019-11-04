public class Player {
    private String name;
    private PieceSet pieceSet;
    private PieceColor playerColor;
    private boolean isInCheck = false;

    public Player(String name, PieceSet set){
        this.name = name;
        this.pieceSet = set;
        this.playerColor = set.getSetColor();
    }

    public PieceSet getPieceSet() {
        return pieceSet;
    }

    public String getName() {
        return name;
    }

    public PieceColor getPlayerColor() {
        return playerColor;
    }

    public void setInCheck(boolean inCheck) {
        isInCheck = inCheck;
    }

    public boolean getIsInCheck(){
        return this.isInCheck;
    }

}
