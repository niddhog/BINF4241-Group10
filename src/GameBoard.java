import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class GameBoard {

    public static int setPlayerNumber(){
        while (true){
            Scanner numberObject = new Scanner(System.in);
            try
            {
                System.out.println("Please enter the number of Players (2-4 Players): ");
                int p = numberObject.nextInt();
                if(p>=2 && p<=4){
                    return p;
                }
                System.out.println("Please select a min. of 2 Players and a max. of 4 Players...");
            }
            catch(InputMismatchException exception)
            {
                System.out.println("You did not enter a whole number...");
            }
        }
    }

    public static int setBoardSize(){
        while (true){
            Scanner boardObject = new Scanner(System.in);
            try
            {
                System.out.println("Please set the Size of the board (enter a whole Number, min. 7): ");
                int n = boardObject.nextInt();
                if(n<7){
                    System.out.println("Please enter a board size of at least 7 fields...");
                }
                return n;
            }
            catch(InputMismatchException exception)
            {
                System.out.println("You did not enter a whole number...");
            }
        }
    }

    public static String[] setPlayerName(int p){
        String[] nameArray = new String[p]; //initialize String array of size p
        Scanner nameObject = new Scanner(System.in);
        for(int i = 1; i <= p; i++){
            System.out.println("Please enter the Name of Player " + i + ": ");
            nameArray[i-1] = nameObject.nextLine();
            if(nameArray[i-1].isEmpty()){
                System.out.println("You did not enter any Name...");
                i--;
            }
            else{
                System.out.println("\n Player " + i + " name: " + nameArray[i-1]);
            }
        }
        return nameArray;
    }

    public static void main(String[] args){
        int p = setPlayerNumber();  //Set the player Count
        int n = setBoardSize(); //Input -> int boardSize = ;
        String[] playerNames = setPlayerName(p); //Set Player Names

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
