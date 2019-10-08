//subclasses: snake, ladder
//String ladder = "->";
//String snake = "<-";

class square {
    public int squareNr; //placement position on board
    public int occupied; //0 = free 1 = occupied

    public square(int squareNr, int occupied) {
        this.squareNr = squareNr;
        this.occupied = occupied;
    }

    public int getOccupied() {return occupied; }

    public void setOccupied(int occupied) {this.occupied = occupied; }

    public int getSquareNr() {return squareNr; }

    public int getBackNr() {return 0;}

    public void setSquareNr(int squareNr) {this.squareNr = squareNr; }

}


class SnakeSquare extends square{
    public int backNr; // holds an integer which corresponds to the field this snake leads back to
    public SnakeSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        backNr = leap;
    }
    @Override
    public int getBackNr(){return backNr; }
    public void setBackNr(int val){ backNr = val; }
}


class LadderSquare extends square{
    public int advanceNr; // holds an integer saying how much a player has to move back
    public LadderSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        advanceNr = leap;
    }
    @Override
    public int getBackNr(){return advanceNr; }
    public void setBackNr(int val){ advanceNr = val; }
}
