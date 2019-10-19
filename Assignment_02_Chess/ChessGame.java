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
        Move[] playedMoves;                                 //actually not necessary to record the movements from the players
        ChessPlayer[] playerList = new ChessPlayer[2];     //list of two to save both player
        Result result;
        CheckStatus checkStatus;
        PieceSet blackSet = new PieceSet;         //creating PieceSets for both players
        blackSet.setColoredSet(PieceColor.BLACK);
        PieceSet whiteSet = new PieceSet;
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
                new Move(currentPlayer, start, end, blackSet, whiteSet);
                if (currentPlayer.getColor() == PieceColor.BLACK) {
                    if (isChecked(whiteSet, blackSet, currentPlayer)) {
                        CheckStatus BlackInCheck = new CheckStatus(CheckStatus.BlackInCheck);
                        BlackInCheck.warning();
                        System.out.println("Invalid turn. Try again");
                        for(int j=0; j<16;j++) {
                            if(blackSet.getList()[j].placeAt() == end){
                                blackSet.getList()[j].placeAt() == start;
                            }
                        }
                    }
                    else if(isChecked(blackSet, whiteSet, currentPlayer)){
                        CheckStatus WhiteInCheck = new CheckStatus(CheckStatus.WhiteInCheck);
                        WhiteInCheck.warning();
                        System.out.println("Invalid turn. Try again.");
                        for(int j=0; j<16;j++) {
                            if(whiteSet.getList()[j].placeAt() == end){
                                whiteSet.getList()[j].placeAt() == start;
                            }
                        }
                    }
                }
            }

            //check and checkmate
            //todo I'm not sure, if the the CheckStatus needed, if it's only text output
            nextTurn(currentPlayer, playerList);
            if (currentPlayer.getColor() == PieceColor.BLACK) {
                if(isCheckmate(whiteSet, blackSet, currentPlayer)){
                    CheckStatus BlackCheckmated = new CheckStatus(CheckStatus.BlackCheckmated);
                    BlackCheckmated.warning();
                }
                else if(isChecked(whiteSet, blackSet, currentPlayer)) {
                    CheckStatus BlackInCheck = new CheckStatus(CheckStatus.BlackInCheck);
                    BlackInCheck.warning();
                }
            }
            else{
                if(isCheckmate(blackSet, whiteSet, currentPlayer)){
                CheckStatus WhiteCheckmated = new CheckStatus(CheckStatus.WhiteInCheck);
                WhiteCheckmated.warning();
            }
                else if(isChecked(blackSet, whiteSet, currentPlayer)){
                    CheckStatus WhiteInCheck = new CheckStatus(CheckStatus.WhiteInCheck);
                    WhiteInCheck.warning();
                }

            }
        }
    }


    //it tests the input "start" and "end" Square of the user for the computation of the movement of the piece
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




    public static void nextTurn(ChessPlayer currentPlayer, ChessPlayer[] player){
        if(currentPlayer==player[0]){
            currentPlayer=player[1];
        }
        else{
            currentPlayer=player[0];
        }
    }


    //checks, if a king in check or checkmate
    //attack already happened, currentPlayer changed, just check afterwards, if a king is in check
    public static boolean isChecked(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Pieces checkedKing = new Pieces;
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j] == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }
        if(attackingSet.getColoredSet() == currentPlayer.getColor()){
            for(int i=0; i<16;i++){
                if(attackingSet.getList()[i].validMoves() == checkedKing.placeAt() && attackingSet.getList()[i].toBeCaptured()==false){
                    Pieces regicide = attackingSet.getList()[i];
                    checkedKing.inCheck()=true;
                    }
                }
            }
        }
    public static boolean isStalemate(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Pieces checkedKing = new Pieces;
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j] == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }
        if(attackingSet.getColoredSet() == currentPlayer.getColor()){
            for(int i=0; i<16;i++){
                if(attackingSet.getList()[i].validMoves() != checkedKing.placeAt() && attackingSet.getList()[i].toBeCaptured()==false
                    && checkedKing.captureFreeMoves()==null){
                    checkedKing.inCheck()=false;
                }
            }
        }
    }
        //currentPlayer is has the defendingSet
    public static boolean isCheckmate(PieceSet attackingSet, PieceSet defendingSet, ChessPlayer currentPlayer){
        Pieces checkedKing;
        Pieces regicide;
        boolean killRegicide=false;
        for(int j=0; j<16;j++) {
            if(defendingSet.getList()[j] == PieceType.KING){
                checkedKing=defendingSet.getList()[j];
            }
        }
        if(attackingSet.getColoredSet() == currentPlayer.getColor()) {
            for (int i = 0; i < 16; i++) {
                if (attackingSet.getList()[i].validMoves() == checkedKing.placeAt &&
                        attackingSet.getList()[i].toBeCaptured()==false) {
                    regicide = attackingSet.getList()[i];
                    break;
                }
            }
        }
        for(int a=0; a<16;a++) {
            if (defendingSet.getList()[a].attackSquares() == regicide.placeAt &&
                    defendingSet.getList().toBeCaptured()==false) {

                return false;
            }
        }


        if(checkedKing.inCheck()==true && checkedKing.captureFreeMoves()==null)
        {
            return true;
            }
    }

    public static Square inputToPosition(String user, ChessBoard chessBoard){

        char y = user.charAt(0);
        int value = y;
        int row = value -96;
        int x = Integer.parseInt(user.substring(0));
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
