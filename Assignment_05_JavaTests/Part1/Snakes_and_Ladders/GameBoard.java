package Snakes_and_Ladders;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Christian, Thanh Cong, Filip
 * @version 1.0
 *
 * The Gameboard class contains the main process.
 */

public class GameBoard {

    /**
     *
     * @param args main process for the whole game flow
     */

    public static void main(String[] args) {
        //INITIAL GAME SETUP///////////////////////////////////////
        int p = setPlayerNumber(), m = 0;  //Set the player Count; Set player rotation int m
        Player[] playerNames = setPlayerName(p); //Set Snakes_and_Ladders.Player Names
        int boardSize = setBoardSize(); //Input -> int boardSize = ;
        int nrOfSnakes = boardSize/11; //# Math.round(boardSize/11)snakes
        int nrOfLadders = boardSize/7; //# Math.round(boardSize/7)ladders
        square[] table = setBoardSquares(boardSize,nrOfSnakes,nrOfLadders); //Array length == boardSize; Snakes_and_Ladders.square objects
        ////////////////////////////////////////////////////////////

        System.out.print("Initial State: \t"); //print initial state with board and players on the first Snakes_and_Ladders.square
        stateOfTurn(p, boardSize, playerNames, table); //initial state: players on the first Snakes_and_Ladders.square

        while(true) {//while game not over
            int overCounter;
            Player playerNow = playerNames[m%p]; //rotate through players
            int backStep;
            int dice = randInt(1, 6);//one player rolls dice
            System.out.print(playerNow.getName() + " rolls " + dice + ": \t"); //print state of current player
            stateOfTurn(p, boardSize, playerNames, table);
            if(playerNow.getPosition()!=0){
                table[playerNow.getPosition()].setOccupied(0);
            }

            //Special Case before Collision detection
            if(playerNow.getPosition() + dice > (boardSize-1)){
                overCounter = (playerNow.getPosition() + dice) - (boardSize-1);
                playerNow.setPosition((boardSize-1) - overCounter);
                dice = 0;
            }
            if(table[playerNow.getPosition()+dice] instanceof SnakeSquare ||
                    table[playerNow.getPosition()+dice] instanceof LadderSquare){
                playerNow.setPosition(table[playerNow.getPosition()+dice].getBackNr());
                dice = 0;
            }

            if(table[playerNow.getPosition()+dice].getOccupied()==1){ //in case player steps on an occupied field
                playerNow.setPosition(0);
                dice = 0;
                }
            else if(table[playerNow.getPosition()+dice].getOccupied()==0){
                table[playerNow.getPosition()+dice].setOccupied(1);
                playerNow.setPosition(playerNow.getPosition()+dice);
                dice = 0;
            }

            if(table[playerNow.getPosition()+dice].getSquareNr() == boardSize-1){
                System.out.print("Final state: \t");
                stateOfTurn(p, boardSize, playerNames, table);//Final State Update = state with moved player
                System.out.println(playerNow.getName() + " wins!");
                break;
            }
            m++;
        }
    }

    /**
     * Takes as input an integer between 2 and 4 and the loop ends. If it's not an integer, then the exeption will be
     * caught or if the integer is too big or too small and both cases stay in the loop.
     *
     * @return if it's not an integer within the range, then a message returns, else the given integer input returns
     * @exception InputMismatchException if the input is a invalid input of the type integer
     */

    public static int setPlayerNumber(){
        while (true){
            Scanner numberObject = new Scanner(System.in);
            try
            {
                System.out.print("Please enter the number of Players (2-4 Players): ");
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

    /**
     *
     * @param p is the number of players, which participate the game
     * @return an {@link Array} of {@link Player}s with their names
     */

    public static Player[] setPlayerName(int p){
        Player[] playerArray = new Player[p]; //initialize Snakes_and_Ladders.Player array of size p
        Scanner nameObject = new Scanner(System.in);

        for(int i = 1; i <= p; i++){
            Player player = new Player();
            System.out.print("Please enter the Name of Snakes_and_Ladders.Player " + i + ": ");
            player.setName(nameObject.nextLine());
            //nameArray[i-1].setName(nameObject.nextLine()); REMOVE IF CODE RUNS CORRECTLY
            player.setPlayernr(i);
            player.setPosition(0);
            playerArray[i-1]=player;
            if(playerArray[i-1].getName().isEmpty()){
                System.out.println("You did not enter any Name...");
                i--;
            }
            else{
                System.out.println("Snakes_and_Ladders.Player " + i + " Name is: " + player.getName()+"\n");
            }
        }
        return playerArray;
    }

    /**
     * We consider to set a minimum of fields to add at least one ladder. We know, it's not necessary to set
     * this restriction, otherwise a too small board doesn't look funny at all.
     * @return an integer with at least 7 fields
     * @throws InputMismatchException occurs if the user input is doesn't match the integer type
     */

    public static int setBoardSize(){
        while (true){
            Scanner boardObject = new Scanner(System.in);
            try
            {
                System.out.print("Please set the Size of the board (enter a whole Number, min. 7): ");
                int n = boardObject.nextInt();
                if(n<7){
                    System.out.println("Please enter a board size of at least 7 fields...");
                    continue;
                }
                System.out.print("\n\n\n");
                return n;
            }
            catch(InputMismatchException exception)
            {
                System.out.println("You did not enter a whole number...");
            }
        }
    }

    /**
     *
     * @param boardSize is the size of the board, which given from the user input by {@link #setBoardSize()}
     * @param nrOfSnakes is the number of snakes, which will be set on the board, calculated by {@link #setBoardSize()}/11
     * @param nrOfLadders is the number of ladders, which will be set on the board, calculated by {@link #setBoardSize()}/7
     * @return a board with all {@link square}
     */

    public static square[] setBoardSquares(int boardSize,int nrOfSnakes, int nrOfLadders) {
        int tempStart, tempEnd;
        square[] boardGame = new square[boardSize]; //initialize Square array of size boardSize
        for (int i = 0; i < boardSize; i++) {
            if(i==0){
                boardGame[i] = new square(i, 1);
            }else{
                boardGame[i] = new square(i, 0);
            }
        }
        int[] snakeLadderArray = new int[boardSize]; //Int Array for SL Start/End calculation
        for(int i = 0; i<snakeLadderArray.length;i++){ snakeLadderArray[i] = i;}
        //Set Snakes and Ladders and assign a Startingpoint and Endpoint to each Snake and Ladder
        while(true){ //complexity of O(#(snakes+ladders) * n)
            int[] image = snakeLadderArray;
            if(nrOfLadders>0){
                int[] tempArray = new int[snakeLadderArray.length-2];
                tempStart = randInt(1,snakeLadderArray.length-3);
                tempEnd = randInt(tempStart+1,snakeLadderArray.length-2);
                boardGame[snakeLadderArray[tempStart]] = new LadderSquare(snakeLadderArray[tempStart],
                        0,snakeLadderArray[tempEnd]);
                snakeLadderArray = resizeArray(image,tempArray,snakeLadderArray[tempStart],snakeLadderArray[tempEnd],
                        "ladder");
                nrOfLadders--;
            }else if(nrOfSnakes>0){
                int[] tempArray = new int[snakeLadderArray.length-2];
                tempStart = randInt(2,snakeLadderArray.length-2);
                tempEnd = randInt(1,tempStart-1);
                boardGame[snakeLadderArray[tempStart]] = new SnakeSquare(snakeLadderArray[tempStart],
                        0,snakeLadderArray[tempEnd]);
                snakeLadderArray = resizeArray(image,tempArray,tempStart,tempEnd,"snake");
                nrOfSnakes--;
            }else{break;}
        }
        return boardGame;
    }

    /**
     *set a range of integer numbers to pick randomly an integer within the range
     * @param min integer can also be picked and is smaller or equal than max
     * @param max integer can also be picked and is greater or equal than min
     * @return a random integer between a range of two integers
     */

    public static int randInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("max has to be greater equal to min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     *
     * @param p is the number of players, which participate the game
     * @param boardSize is the size of the board, which given from the user input by {@link #setBoardSize()}
     * @param players is an {@link Array} of {@link Player}s with their names
     * @param table is a board with all {@link square}
     */


    public static void stateOfTurn(int p, int boardSize, Player[] players, square[] table){

        for (int i = 0; i < boardSize; i++) {
            if(isSnake(table[i])){ //todo identify if it's a snake or ladder
                System.out.print("[" + (table[i].getBackNr()+1) + "<-" + (table[i].getSquareNr()+1)+"]");
            }
            else if(isLadder(table[i])){ //todo necessary to allocate the snakes and ladders
                System.out.print("[" + (table[i].getSquareNr()+1) + "->" + (table[i].getBackNr()+1) + "]");
            }
            else if (table[i].getOccupied() == 0) {
                System.out.print("[" + (i + 1) + "]");
            }
            else{
                System.out.print("[" + (table[i].getSquareNr()+1));
                for (int j = 0; j < p; j++) {
                    if (players[j].getPosition() == table[i].getSquareNr()) {
                        System.out.print("<" + players[j].getName() + ">");
                    }
                }
                System.out.print("]");
            }

        }
        System.out.print("\n");
    }

    /**
     *
     * @param test takes a {@link square}
     * @return <code>true</code>, if it's a {@link SnakeSquare}, <code>true</code> if it's not a {@link SnakeSquare}
     */

    public static boolean isSnake(square test){
        if(test instanceof SnakeSquare){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param test takes a {@link square}
     * @return <code>true</code>, if it's a {@link LadderSquare}, <code>true</code> if it's not a {@link LadderSquare}
     */

    public static boolean isLadder(square test){
        if(test instanceof LadderSquare){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param image is an {@link Array} of integers of the position number of {@link square#squareNr}
     * @param tempArray is a new empty {@link Array} of the length of the current image with 2 less squares
     * @param tempStart is a random integer between the range of the position of the second {@link square}
     *                  and the third last {@link square}
     * @param tempEnd is a random integer between tempStart+1 and the position of the second last {@link square}
     * @param type provides the string "ladder" or "snake"
     * @return an {@link Array} without the two square positions, which part of a "snake" or "ladder"
     */

    public static int[] resizeArray(int[] image, int[] tempArray, int tempStart, int tempEnd, String type){
        int count = 0;
        if(type.equals("snake")){
            int temp = tempStart;
            tempStart = tempEnd;
            tempEnd = temp;
        }
        for(int i=0; i<tempArray.length; i++){
            //System.out.println("count: " + count + " i: " + i);
            if(image[count]!=tempStart && image[count]!=tempEnd) {
                tempArray[i]=image[count];
                count++;
            }else{
                count++;
                if(image[count]!=tempStart && image[count]!=tempEnd){
                    tempArray[i]=image[count];
                    count++;
                }else{
                    count++;
                    tempArray[i]=image[count];
                    count++;
                }
            }
        }
        return tempArray;
    }
}