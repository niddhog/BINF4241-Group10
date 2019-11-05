import java.util.ArrayList;

public class ChessPieceIterator implements Iterator {

    private ArrayList<Piece> pieces;
    private int position = 0;

    public ChessPieceIterator(ArrayList<Piece> pieces){
        this.pieces = pieces;
    }


    @Override
    public boolean hasNext() {
        if(position >= pieces.size() || pieces.get(position) == null){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public Object next() {
        Piece piece = pieces.get(position);
        position += 1;
        return piece;
    }

}
