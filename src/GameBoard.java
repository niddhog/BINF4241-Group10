import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GameBoard {


    public static void main(String[] args) {


        int p = setPlayerNumber();  //Set the player Count

        player[] playerNames = setPlayerName(p); //Set Player Names

        int boardSize = setBoardSize(); //Input -> int boardSize = ;


        //Input -> What´s their name? e.g. <Player 1>

        //Datastructure array with length boardSize and each cell is a square



        /*
        square image [1][2->6][3][4][5][6][7->9][8][9][10][11->5][..][boardSize]
        randomized # Math.round(boardSize/10)snakes and # Math.round(boardSize/5)ladders
         */

        //print initial state with board and players on the first square
        //String /stateBefore = initial state

        //initial state: players on the first square

        //while game not over
        for(int m = 1; true; m++) {
            player playerNow = playerNames[m%p];

            //one player rolls dice
            int dice = randInt(1, 6);

            //print state this.player + " rolls " + this.dice + stateBefore

            System.out.print(playerNow + " rolls " + dice + ": ");

            for (int i = 1; i <= boardSize; i++) {

                        if (i == 1) {
                    System.out.print("[" + i);

                            for (int a = 0; a < p; a++) {
                                if(playerNames[a].getPosition()== i) {

                            System.out.print("<" + playerNames[a].getName() + ">");
                        }
                    }
                    System.out.println("]");
                }
            }

            //move the player (position+dice number)
            playerNow.setPosition(playerNow.getPosition()+dice);

            /*if(this.player.position == square.squarenr && square.occupied == 1){
                    this.player.position=1;}
             */

            // updatedState = state with moved player

            if (this.player.position == boardSize){
                System.out.println("Final state: " + updatedState \n this.player + "wins!");
                break;
                }
            }


        }

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


    public static player[] setPlayerName(int p){
        player[] nameArray = new player[p]; //initialize String array of size p
        Scanner nameObject = new Scanner(System.in);
        for(int i = 1; i <= p; i++){
            System.out.println("Please enter the Name of Player " + i + ": ");
            nameArray[i-1].setName(nameObject.nextLine());
            player.setPosition(i);
            if(nameArray[i-1].getName().isEmpty()){
                System.out.println("You did not enter any Name...");
                i--;
            }
            else{
                System.out.println("\n Player " + i + " name: " + nameArray[i-1]);
            }
        }
        return nameArray;
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



    public static int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max have to be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /*public static void movePlayer(int oldpostion, int dice, player) { //make sure to define methods outside the main method

        player.setposition(oldpostion + dice);

    }*/
}

