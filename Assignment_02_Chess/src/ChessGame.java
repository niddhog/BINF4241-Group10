import java.sql.ResultSet;
import java.util.Scanner;


//Init Player 1 and Player 2
//Set their colors
//evt. Log
//StartGame
//white player begins
//Check for Win Condition

    /*
    playedMoves - Keep a record of moves
    turn - Indicate either it is a Black's turn or a White's turn -> changes in the loop condition
    players - Represent the two players, this can be Human/Human
    result - Indicate the result of a game
        -> represent only blackWins/whiteWins/draw
    checkStatus - Indicate which side is being checked or checkmated
        -> whiteChecked/blackChecked/whiteCheckMate/blackCheckMate
     */

public class ChessGame {

    public static void main(String[] args) {
        ChessPlayer[] playerList = new ChessPlayer[2];     //list of two to save both player
        CheckStatus checkStatus;
        PieceSet blackSet = new PieceSet(PieceColor.BLACK);         //creating PieceSets for both players
        blackSet.setColoredSet(PieceColor.BLACK);
        PieceSet whiteSet = new PieceSet(PieceColor.WHITE);
        whiteSet.setColoredSet(PieceColor.WHITE);
        ChessPlayer currentPlayer;


        ChessPlayer player1 = new ChessPlayer(setPlayerName(1), setPlayerColor(1));

        if (player1.getColor() == PieceColor.WHITE) {
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2), PieceColor.BLACK);
            playerList[0] = player1;
            playerList[1] = player2;
            currentPlayer = playerList[0];
        } else {
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2), PieceColor.WHITE);
            playerList[0] = player1;
            playerList[1] = player2;
            currentPlayer = playerList[1];
        }

        ChessBoard board = new ChessBoard(player1.getColor()); //creates Board with Player 1 on Top of the Board
        board.display();                                       //todo board needs the pieces








        //todo this loop represents one turn of one player, check this to ensure the game works perfectly
        while (true) {
            while(true) {
                String coordinatesStart = inputStart();     //user picks piece
                String coordinatesEnd = inputEnd();         //user set piece on new square
                Square start = inputToPosition(coordinatesStart, board);
                Square end = inputToPosition(coordinatesEnd, board);
                new Move(currentPlayer, start, end, blackSet, whiteSet, board);
                if (currentPlayer.getColor() == PieceColor.BLACK) {
                    if (isChecked(whiteSet, blackSet, currentPlayer)) {
                        //System.out.println("Black king is in check.");
                        System.out.println("Invalid turn. Try again");
                        for(int j=0; j<16;j++) {
                            //if movement would make space for a checkmate, the ove is invalid:
                            if(blackSet.getList()[j].getPlaceAt() == end){
                                blackSet.getList()[j].setPlaceAt(start);
                            }
                        }
                    }


                    // I am testing, if the current player made a invalid move, so his King is in a check situation
                    // thus, at the opponent´s turn the king would be killed
                    else if(isChecked(blackSet, whiteSet, currentPlayer)){
                        //System.out.println("Black king is in check.");
                        System.out.println("Invalid turn. Try again.");
                        for(int j=0; j<16;j++) {
                            if(whiteSet.getList()[j].getPlaceAt() == end){
                                whiteSet.getList()[j].setPlaceAt(start);
                            }
                        }
                    }
                }
                break;
            }


            //player changed before the check comes, thus the defending player can reacts, if it´s possible
            //check and checkmate
            //todo I'm not sure, if the the CheckStatus needed, if it's only text output
            currentPlayer = nextTurn(currentPlayer, playerList);
            if (currentPlayer.getColor() == PieceColor.BLACK) {
                if(isCheckmate(whiteSet, blackSet, currentPlayer)){
                    System.out.println("Black king is in check.");
                }
                else if(isChecked(whiteSet, blackSet, currentPlayer)) {
                    System.out.println("Black king is in check.");
                }
            }
            else{
                if(isCheckmate(blackSet, whiteSet, currentPlayer)){
                    System.out.println("Black king is in check.");
            }
                else if(isChecked(blackSet, whiteSet, currentPlayer)){
                    System.out.println("Black king is in check.");
                }

            }
        }
    }


    //it tests the input "start" Square of the user for the computation of the movement of the piece
    public static String inputStart(){
        while(true) {

            //user chooses the piece
            Scanner userMove = new Scanner(System.in);

            while (true) {
                System.out.print("Position of the piece, that should move: ");
                String start = userMove.nextLine();
                boolean y=false;
                boolean x=false;
                switch (start.charAt(0)){
                    case'a':
                    case'b':
                    case'c':
                    case'd':
                    case'e':
                    case'f':
                    case'g':
                    case'h':
                        y=true;
                }
                switch (start.charAt(1)){
                    case'1':
                    case'2':
                    case'3':
                    case'4':
                    case'5':
                    case'6':
                    case'7':
                    case'8':
                        x=true;
                }
                if (start.length() == 2 && x == true && y == true){
                    return start;

                }
                else {
                    System.out.println("Your position is incorrect. Choose an input of length 2 with a " +
                            "combination of the named squares of the board.");
                }
            }
        }
    }


    //it tests the input "end" Square of the user for the computation of the movement of the piece
    public static String inputEnd() {
        Scanner userMove = new Scanner(System.in);

        while (true) {
            System.out.print("Position where the piece move to: ");
            String end = userMove.nextLine();
            boolean y=false;
            boolean x=false;
            switch (end.charAt(0)){
                case'a':
                case'b':
                case'c':
                case'd':
                case'e':
                case'f':
                case'g':
                case'h':
                    y=true;
            }
            switch (end.charAt(1)){
                case'1':
                case'2':
                case'3':
                case'4':
                case'5':
                case'6':
                case'7':
                case'8':
                    x=true;
            }
            if (end.length() == 2 && x == true && y == true){
                return end;
            }
            else {
                System.out.println("Your position is incorrect. Choose an input of length 2 with a " +
                        "combination of the named squares of the board.");
            }
        }
    }



    //change the player, for next turn and check situation
    public static ChessPlayer nextTurn(ChessPlayer currentPlayer, ChessPlayer[] player){
        if(currentPlayer==player[0]){
            return player[1];
        }
        else{
            return player[0];
        }
    }


    //checks, if a king in check or checkmate
    //attack already happened, currentPlayer changed, just check afterwards, if a king is in check
    public static boolean isChecked(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Piece checkedKing = new King(currentPlayer.getColor());
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j].getPieceType() == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }
        if(attackingSet.getColoredSet() == currentPlayer.getColor()){
            for(int i=0; i<16;i++){
                if(attackingSet.getList()[i].validMoves() == checkedKing.getPlaceAt() && attackingSet.getList()[i].toBeCaptured()==false){
                    Piece regicide = attackingSet.getList()[i];
                    checkedKing.inCheck()=true;
                    }
                }
            }
        }

        //currentPlayer is has the defendingSet
    public static boolean isCheckmate(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Piece checkedKing = new King(currentPlayer.getColor());
        Piece regicide;
        boolean killRegicide=false;
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j].getPieceType() == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }
        if(attackingSet.getColoredSet() == currentPlayer.getColor()) {
            for (int i = 0; i < 16; i++) {
                if (attackingSet.getList()[i].validMoves() == checkedKing.getPlaceAt() &&
                        attackingSet.getList()[i].toBeCaptured()==false) {
                    regicide = attackingSet.getList()[i];
                    break;
                }
            }
        }
        for(int a=0; a<16;a++) {
            if (defendingSet.getList()[a].attackSquares() == regicide.getPlaceAt() &&
                    defendingSet.getList().toBeCaptured()==false) {

                return false;
            }
        }

        // if stalemate and check is active, then it follows checkemate
        // todo BUT there´s is a small possibility, this case won´t work, if there is a piece can block the way to the checked an stalemated King
        if(checkedKing.inCheck()==true && checkedKing.captureFreeMoves()==null)
        {
            return true;
            }
    }

    public static Square inputToPosition(String user, ChessBoard chessBoard){

        char y = user.charAt(0);
        int value = y;
        int row = value - 96;
        int x = Integer.parseInt(user.substring(1));
        int column = 8-x;
        return chessBoard.getSquare(row, column);

    }


    public static String setPlayerName(int p){
        Scanner nameObject = new Scanner(System.in);
        while(true){
            System.out.print("Please enter the Name of Player " + p + ": ");
            String name = nameObject.nextLine();
            if(name.isEmpty()){
                System.out.println("You did not enter any Name...");
            }
            else{
                return name;
            }
        }
    }


    public static PieceColor setPlayerColor(int p){
        Scanner colorObject = new Scanner(System.in);
        while(true){
            System.out.print("Please enter the Color(W/B) of Player " + p + ": ");
            String color = colorObject.nextLine();
            if(color.isEmpty()){
                System.out.println("You did not enter any color, please input W or B...");
            }
            else if(color.equals("B")){
                return PieceColor.BLACK;
            }else if(color.equals("W")){
                return PieceColor.WHITE;
            }
            else{
                System.out.println("Your input is invalid, please enter W or B...");
            }
        }
    }


}
