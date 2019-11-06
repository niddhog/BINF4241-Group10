public class setIterator implements Iterator {
    Piece[] pieces;
    int position = 0;

    public setIterator(Piece[] pieces){
        this.pieces = pieces;
    }

    public Piece next() {
        Piece pieceItem = pieces[position];
        position = position +1;
        return pieceItem;
    }

    public boolean hasNext(){
        if (position >= pieces.length || pieces[position] == null){
            return false;
        }
        else{
            return true;
        }
    }
}
