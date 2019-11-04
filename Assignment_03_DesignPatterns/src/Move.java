import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

public class Move implements Subject {
    private List<Square> observers = new ArrayList<>();

    public void move(Board gameBoard, Coordinates s, Coordinates e) {
        Piece movedPiece = gameBoard.getBoard()[s.getX()][s.getY()].getPieceOnSquare();
        notifyObserver(s.getX(), s.getY(), e.getX(), e.getY(), movedPiece);
    }

    @Override
    public void registerObserver(Square observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Square observer) {
        for (Square eachSquare : observers){
            if(eachSquare==observer){
                observers.remove(eachSquare);
            }
        }
    }

    @Override
    public void notifyObserver(int xStart, int yStart, int xEnd, int yEnd, Piece movedPiece) {
        for (Square eachSquare : observers){
            eachSquare.update(xStart, yStart, xEnd, yEnd, movedPiece);
        }
    }
}
