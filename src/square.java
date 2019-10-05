//subclasses: snake, ladder

class square {

    private static int squareNr; //placement position on board
    private static int occupied; //0 = free 1 = occupied

    public square(int squareNr, int occupied) {
        this.squareNr = squareNr;
        this.occupied = occupied;
    }

    public static int getOccupied() {
        return occupied;
    }

    public static void setOccupied(int occupied) {
        square.occupied = occupied;
    }

    public static int getSquareNr() {
        return squareNr;
    }

    public static void setSquareNr(int squareNr) {
        square.squareNr = squareNr;
    }

    //String ladder = "->";
    //String snake = "<-";
    public void printSquare(){

        System.out.println("[" + square.getSquareNr() + "]");
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

    public void setBackNr(int val){
        backNr = val;
    }

    public int teleportNr(int squareNr){
        return squareNr-backNr;
    }
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

    public void setBackNr(int val){
        advanceNr = val;
    }

    public int teleportNr(int squareNr){
        return squareNr+advanceNr;
    }
}
