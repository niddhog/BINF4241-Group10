public interface Subject {
    void registerObserver(Square observer);
    void removeObserver(Square observer);
    void notifyObserver(int xStart, int yStart, int xEnd, int yEnd, Piece movedPiece, Scoreboard scoreBoard);
}
