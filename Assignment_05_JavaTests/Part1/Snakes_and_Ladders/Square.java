package Snakes_and_Ladders;//subclasses: snake, ladder
//String ladder = "->";
//String snake = "<-";

class square {
    public int squareNr; //placement position on board
    public int occupied; //0 = free 1 = occupied

    /**
     *
     * @param squareNr marks its position on the gameboard
     * @param occupied is 0, if it's not occupied and 1, if it's occupied
     */

    public square(int squareNr, int occupied) {
        this.squareNr = squareNr;
        this.occupied = occupied;
    }

    /**
     *
     * @return integer 0, if it's not occupied, 1, if it's occupied by a {@link Player}
     */

    public int getOccupied() {return occupied; }

    /**
     *
     * @param occupied set to 0, if no player is on the square, set to 1, if a player lands on
     */

    public void setOccupied(int occupied) {this.occupied = occupied; }

    /**
     *
     * @return
     */

    public int getSquareNr() {return squareNr; }

    /**
     *
     * @return position 0, if a place is already occupied
     */

    public int getBackNr() {return 0;}

    /**
     *
     * @param squareNr position on the board
     */

    public void setSquareNr(int squareNr) {this.squareNr = squareNr; }

}


class SnakeSquare extends square{
    public int backNr; // holds an integer which corresponds to the field this snake leads back to

    /**
     *
     * @param squareNr position on the board
     * @param occupied set to 0, if no player is on the square, set to 1, if a player lands on
     * @param leap position by the rule to land on a snake
     */

    public SnakeSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        backNr = leap;
    }


    @Override
    /**
     *
     * @return position by the rule to land on a snake
     */
    public int getBackNr(){return backNr; }

    /**
     *
     * @param val position by the rule to land on a snake
     */
    public void setBackNr(int val){ backNr = val; }
}


class LadderSquare extends square{

    public int advanceNr; // holds an integer saying how much a player has to move back

    /**
     *
     * @param squareNr position on the board
     * @param occupied set to 0, if no player is on the square, set to 1, if a player lands on
     * @param leap position by the rule to land on a ladder
     */

    public LadderSquare(int squareNr, int occupied, int leap){
        super(squareNr,occupied);
        advanceNr = leap;
    }



    @Override
    /**
     *
     * @returnposition by the rule to land on a ladder
     */
    public int getBackNr(){return advanceNr; }

    /**
     *
     * @param val position by the rule to land on a ladder
     */
    public void setBackNr(int val){ advanceNr = val; }
}
