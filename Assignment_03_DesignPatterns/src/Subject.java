public interface Subject {
    public void registerObserver(Square observer);
    public void removeObserver(Square observer);
    public void notifyObserver(int xStart, int yStart, int xEnd, int yEnd, Piece movedPiece);
}
