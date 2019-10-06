//subclasses: snake, ladder

class square {

    private int squareNr; //placement position on board
    private int occupied; //0 = free 1 = occupied

    public square(int squareNr, int occupied) {
        this.squareNr = squareNr;
        this.occupied = occupied;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getSquareNr() {
        return squareNr;
    }

    public void setSquareNr(int squareNr) {
        this.squareNr = squareNr;
    }

    //String ladder = "->";
    //String snake = "<-";
    public void printSquare(){

        System.out.println("[" + squareNr + "]");
    }
}


class SnakeSquare extends square{
    private int backNr; // holds an integer saying how much a player has to move back
    public SnakeSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        backNr = leap;
    }
    @Override
    public void printSquare(){
        //System.out.println("[" + this.squareNr-this.backNr +"<-"+ this.squareNr + "]");
    }

    public void setBackNr(int val){
        backNr = val;
    }
    public int getBackNr(){return backNr;}

    public int teleportNr(int squareNr){
        return (squareNr-backNr);
    }
}


class LadderSquare extends square{
    private int advanceNr; // holds an integer saying how much a player has to move back
    public LadderSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        advanceNr = leap;
    }
    @Override
    public void printSquare(){
        //System.out.println("[" + this.squareNr +"->"+ this.squareNr+this.advanceNr + "]");
    }

    public void setAdvNr(int val){
        advanceNr = val;
    }
    public int getAdvNr(){return advanceNr; }

    public int teleportNr(int squareNr){
        return (squareNr+advanceNr);
    }
}
