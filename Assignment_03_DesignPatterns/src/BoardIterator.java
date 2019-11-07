import java.util.ArrayList;

public class BoardIterator implements Iterator {
    private ArrayList<Square> squares;
    private int position = 0;

    public BoardIterator(ArrayList<Square> squares){
        this.squares = squares;
    }


    @Override
    public boolean hasNext() {
        if(position >= squares.size() || squares.get(position) == null){
            return false;
        } else{
            return true;
        }
    }


    @Override
    public Object next() {
        Square square = squares.get(position);
        position += 1;
        return square;
    }
}
