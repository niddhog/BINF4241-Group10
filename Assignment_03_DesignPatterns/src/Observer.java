public interface Observer {
    void update(int xStart, int yStart, int xEnd, int yEnd, Piece movedPiece, Scoreboard scoreBoard);
}
