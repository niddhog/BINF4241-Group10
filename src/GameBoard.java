import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class GameBoard {

    public static void setPlayerNumber(){
        while (true){
            Scanner numberObject = new Scanner(System.in);
            try
            {
                System.out.println("Please enter the number of Players (2-4 Players): \n");
                int p = numberObject.nextInt();
                if(p>=2 && p<=4){
                    break;
                }
                System.out.println("Please select a min. of 2 Players and a max. of 4 Players...");
            }
            catch(InputMismatchException exception)
            {
                System.out.println("You did not enter a whole number...");
            }
        }
    }

    public static void setBoardSize(){
        while (true){
            Scanner boardObject = new Scanner(System.in);
            try
            {
                System.out.println("Please set the Size of the board (enter a whole Number, min. 7): \n");
                int n = boardObject.nextInt();
                if(n<7){
                    System.out.println("Please enter a board size of at least 7 fields...");
                }
                break;
            }
            catch(InputMismatchException exception)
            {
                System.out.println("You did not enter a whole number...");
            }
        }
    }

    public static void main(String[] args){
        setPlayerNumber();  //Set the player Count
        setBoardSize(); //Input -> int boardSize = ;



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
