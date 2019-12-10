package Snakes_and_Ladders;

/**
 * @author Christian
 * @author Thanh Cong
 * @author Filip
 * @version 1.0
 */

public class Player {

    private int playernr;
    private int position;
    private String myName;

    /**
     *
     * @param myName is the string input to name the player
     */
    public void setName(String myName) {
        this.myName = myName;
    }

    /**
     *
     * @return the name of the player as string
     */

    public String getName(){
        return myName;
    }

    /**
     *
     * @param position is the current position of the player on the board
     */

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     *
     * @return the current position of the player on the board
     */

    public int getPosition(){
        return position;
    }

    /**
     *
     * @param playernr is the number in which order the players have their turn
     */

    public void setPlayernr(int playernr) {
        this.playernr = playernr;
    }

    /**
     *
     * @return the number of the order for the turn
     */

    public int getPlaynernr() {
        return playernr;
    }

}