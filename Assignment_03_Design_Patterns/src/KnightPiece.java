public interface KnightPiece {
    public boolean validMove(int xfrom, int yfrom, int xto, int yto, boolean capture);
    public void setPieceName(String pieceName);
    public String getPieceName();
    public void setPieceType(PieceType pieceType);
    public PieceType getPieceType();
    public void setPieceColor(PieceColor pieceColor);
    public PieceColor getPieceColor();
    public void setMoved();
}
