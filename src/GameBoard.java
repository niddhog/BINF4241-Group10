import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

//square image [1][2->6][3][4][5][6][7->9][8][9][10][11->5][..][boardSize]



public class GameBoard {                    /*todo IMPORTANT: in the methods and classes, I don't really understand
                                                the meaning/behaviour of "static", pls take a look" ALSO: Plz
                                                use First Capital Letter for Classes*/


    public static void main(String[] args) {
        //INITIAL GAME SETUP///////////////////////////////////////
        int p = setPlayerNumber();  //Set the player Count
        Player[] playerNames = setPlayerName(p); //Set Player Names
        int boardSize = setBoardSize(); //Input -> int boardSize = ;
        int nrOfSnakes = boardSize/11; //# Math.round(boardSize/11)snakes
        int nrOfLadders = boardSize/7; //# Math.round(boardSize/7)ladders
        square[] table = setBoardSquares(boardSize,nrOfSnakes,nrOfLadders); //Array with length boardSize and each cell is a square
        ////////////////////////////////////////////////////////////
        //todo method placing snakes and ladders
        System.out.print("Initial State: "); //print initial state with board and players on the first square
        stateOfTurn(p, boardSize, playerNames, table); //initial state: players on the first square



        int m = 0;
        while(true) {                  //while game not over

            Player playerNow = playerNames[m%3];

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


    public static Player[] setPlayerName(int p){
        Player[] playerArray = new Player[p]; //initialize Player array of size p
        Scanner nameObject = new Scanner(System.in);

        for(int i = 1; i <= p; i++){
            Player player = new Player();
            System.out.println("Please enter the Name of Player " + i + ": ");
            player.setName(nameObject.nextLine());
            //nameArray[i-1].setName(nameObject.nextLine()); REMOVE IF CODE RUNS CORRECTLY
            player.setPlayernr(i);
            player.setPosition(1);
            if(playerArray[i-1].getName().isEmpty()){
                System.out.println("You did not enter any Name...");
                i--;
            }
            else{
                System.out.println("\n Player " + i + " name: " + player.getName());
            }
        }
        return playerArray;
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


    public static square[] setBoardSquares(int boardSize,int nrOfSnakes, int nrOfLadders) {
        int tempStart, tempEnd;
        square[] boardGame = new square[boardSize]; //initialize Square array of size boardSize
        for (int i = 0; i < boardSize; i++) {boardGame[i] = new square(i, 0);}
        int[] snakeLadderArray = new int[boardSize]; //Int Array for SL Start/End calculation
        for(int i = 0; i<snakeLadderArray.length;i++){ snakeLadderArray[i] = i;}

        //Set Snakes and Ladders and assign a Startingpoint and Endpoint to each Snake and Ladder
        while(true){ //complexity of O(#(snakes+ladders) * n)
            if(nrOfLadders>0){
                int[] tempArray = new int[snakeLadderArray.length-2];
                tempStart = randInt(1,snakeLadderArray.length-3);
                tempEnd = randInt(tempStart+1,snakeLadderArray.length-2);
                boardGame[tempStart] = new LadderSquare(tempStart,0,tempEnd);
                snakeLadderArray = resizeArray(tempArray,tempStart,tempEnd,"ladder");
                nrOfLadders--;
            }else if(nrOfSnakes>0){
                int[] tempArray = new int[snakeLadderArray.length-2];
                tempStart = randInt(2,snakeLadderArray.length-2);
                tempEnd = randInt(1,tempStart-1);
                boardGame[tempStart] = new SnakeSquare(tempStart,0,tempEnd);
                snakeLadderArray = resizeArray(tempArray,tempStart,tempEnd,"snake");
                nrOfSnakes--;
            }else{break;}
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

    public static void stateOfTurn(int p, int boardSize, Player playerNames[], square table[]){
        for (int i = 1; i <= boardSize; i++) {

            if(isSnake(table[i-1])){ //todo identify if it's a snake or ladder
                System.out.print("<" + table[i-1].teleportNr() + "<-" + table[i-1].getSquareNr()+">");
            }

            else if(isLadder(table[i-1])){ //todo necessary to allocate the snakes and ladders
                System.out.print("<" + table[i-1].teleportNr() +
                        "<-" + table[i-1].getSquareNr()+">");
            }
            else if (i == 1){
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

    public static int[] resizeArray(int[] tempArray, int tempStart, int tempEnd, String type){
        if(type.equals("snake"){
            int temp = tempStart;
            tempStart = tempEnd;
            tempEnd = temp;
        }
        for(int i=0; i<tempStart; i++){
            tempArray[i] = i;
        }
        for(int i=tempStart+1; i<tempEnd; i++){
            tempArray[i] = i;
        }
        for(int i=tempEnd+1; i<tempArray.length; i++){
            tempArray[i] = i;
        }
        return tempArray;
    }

    /*public static void movePlayer(int oldpostion, int dice, player) { //make sure to define methods outside the main method
        player.setposition(oldpostion + dice);
    }*/
}