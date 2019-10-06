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

    public void setSquareNr(int squareNr) {this.squareNr = squareNr; }

    public void printSquare(){
        System.out.println("[" + this.squareNr + "]");
    }
}


class SnakeSquare extends square{
    public int backNr; // holds an integer saying how much a player has to move back
    public SnakeSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        backNr = leap;
    }
    @Override
    public void printSquare(){
        //System.out.println("[" + this.squareNr-this.backNr +"<-"+ this.squareNr + "]");
    }

    public void setBackNr(int val){ backNr = val; }
    public int getBackNr(){return backNr; }
    public int teleportNr(int squareNr){ return (squareNr-backNr); }
}


class LadderSquare extends square{
    public int advanceNr; // holds an integer saying how much a player has to move back
    public LadderSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        advanceNr = leap;
    }
    @Override
    public void printSquare(){
        //System.out.println("[" + this.squareNr +"->"+ this.squareNr+this.advanceNr + "]");
    }

    public void setBackNr(int val){ advanceNr = val; }
    public int getAdvNr(){return advanceNr; }
    public int teleportNr(int squareNr){ return (squareNr+advanceNr); }
}
