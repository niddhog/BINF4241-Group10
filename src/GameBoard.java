import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class GameBoard {

    public static void main(String[] args){

        //Input -> int boardSize = ;

        //how many players 2-4
        Scanner numberObject = new Scanner(System.in);
        System.out.println("Please enter the number of Players: \n");
        int numberOfPlayers = numberObject.nextInt();

        //Input -> What´s their name? e.g. <Player 1>




        /*
        square image [1][2->6][3][4][5][6][7->9][8][9][10][11->5][..][boardSize]
        randomized # Math.round(boardSize/10)snakes and # Math.round(boardSize/5)ladders
         */

        //print initial state with board and players on the first square
        //String /stateBefore = initial state

        //while game not over

            // String stateBefore

            //one player rolls dice

            //print state this.player + " rolls " + this.dice + stateBefore
    }
            //move the player (position+dice number)

            /*if(this.player.position == square.squarenr && square.occupied == 1){
                    this.player.position=1;}
             */

            // updatedState = state with moved player

            /*if (this.player.position == boardSize){
            System.out.println("Final state: " + updatedState \n this.player + "wins!);
            break;
            }

             */



    public static void movePlayer() { //make sure to define methods outside the main method

        //if

    }
}
