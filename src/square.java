//subclasses: snake, ladder

class square {
    public int squareNr; //placement position on board
    public int occupied; //0 = free 1 = occupied

    public square(int squareNr, int occupied) {
        this.squareNr = squareNr;
        this.occupied = occupied;
    }

    //String ladder = "->";
    //String snake = "<-";
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

    public void setBackNr(int val){
        backNr = val;
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
}
