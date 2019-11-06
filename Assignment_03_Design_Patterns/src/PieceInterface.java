public interface PieceInterface {
    public void setPieceName(String pieceName);
    public String getPieceName();
    public void setPieceType(PieceType pieceType);
    public PieceType getPieceType();
    public void setPieceColor(PieceColor pieceColor);
    public PieceColor getPieceColor();
    public void setMoved();
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture);
}
