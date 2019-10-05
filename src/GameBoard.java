import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GameBoard {                    /*todo IMPORTANT: in the methods and classes, I don't really understand
                                                the meaning/behaviour of "static", pls take a look"*/


    public static void main(String[] args) {


        int p = setPlayerNumber();  //Set the player Count

        player[] playerNames = setPlayerName(p); //Set Player Names

        int boardSize = setBoardSize(); //Input -> int boardSize = ;

        //Datastructure array with length boardSize and each cell is a square
        square[] table = boardsquares(boardSize);


        /*
        square image [1][2->6][3][4][5][6][7->9][8][9][10][11->5][..][boardSize]
        randomized # Math.round(boardSize/10)snakes and # Math.round(boardSize/5)ladders
         */
        int nrOfSnakes = boardSize/7;
        int nrOfLadders = boardSize/11;


                                                                            //todo method placing snakes and ladders






        //print initial state with board and players on the first square
        //initial state: players on the first square

        System.out.print("Initial State: ");
        stateOfTurn(p, boardSize, playerNames, table);



        int m = 0;
        while(true) {                  //while game not over

            player playerNow = playerNames[m%3];

            int backstep;
            int dice = randInt(1, 6);                               //one player rolls dice


            System.out.print(playerNow + " rolls " + dice + ": "); //print state this.player + " rolls " + this.dice + stateBefore

            stateOfTurn(p, boardSize, playerNames, table);


            for(int i = 0; i< boardSize; i++){                              //boardgame
                if(table[i].getSquareNr() == playerNow.getPosition()){
                    square.setOccupied(0);
                    break;
                }
            }

            if(playerNow.getPosition() + dice >boardSize){
                backstep =  boardSize-(playerNow.getPosition()+dice-boardSize);
            }
            else{
                backstep = playerNow.getPosition() + dice;
            }


            if(backstep == square.getSquareNr() && square.getOccupied() == 1){ //already occupied
                    playerNow.setPosition(1);
                    } else{
                    playerNow.setPosition(backstep);}         //move the player (position+dice number)



            if(playerNow.getPosition()!=1){
                table[playerNow.getPosition()-1].setOccupied(1);        //
            }



            if (playerNow.getPosition() == boardSize){
                System.out.println("Final state: ");
                stateOfTurn(p, boardSize, playerNames, table);            // updatedState = state with moved player
                System.out.println(playerNow.getName() + " wins!");
                break;
                }
            m++;
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
            player.setPlayernr(i);
            player.setPosition(1);
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

    public static square[] boardsquares(int p) {
        square[] boardGame = new square[p]; //initialize String array of size p
        for (int i = 1; i <= p; i++) {
            boardGame[i-1] = new square(i, 0);
        }
        return boardGame;
    }




    public static int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max have to be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void stateOfTurn(int p, int boardSize, player playerNames[], square table[]){
        for (int i = 1; i <= boardSize; i++) {

            if(boolean isSnake(square table[i-1])){                         //todo identify if it's a snake or ladder
                System.out.print("<" + table[i-1].teleportNr() + "<-" + table[i-1].getSquareNr()+">");
            }

            else if(boolean isLadder(square table[i-1])){                    //todo necessary to allocate the snakes and ladders
                System.out.print("<" + table[i-1].teleportNr() +
                        "<-" + table[i-1].getSquareNr()+">");
            }
                else (i == 1){
                    System.out.print("[" + i);

                    for (int a = 0; a < p; a++) {
                        if (playerNames[a].getPosition() == i) {

                            System.out.print("<" + playerNames[a].getName() + ">");
                        }
                    }
                    System.out.println("]");
                }

        }
    }
     public static boolean isSnake(square test){
        if(test instanceof SnakeSquare){
            return true;
        }
        else {
            return false;
        }
     }

    public static boolean isLadder(square test){
        if(test instanceof SnakeSquare){
            return true;
        }
        else {
            return false;
        }
    }

    /*public static void movePlayer(int oldpostion, int dice, player) { //make sure to define methods outside the main method

        player.setposition(oldpostion + dice);

    }*/
}

