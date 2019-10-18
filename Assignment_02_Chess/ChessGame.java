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

public class ChessGame implements PlayerBoard {



    public static void main(String[] args)
    {
        

        ChessPlayer player1 = new ChessPlayer(setPlayerName(1),setPlayerColor(1));

        if(player1.getColor()==PieceColor.WHITE){
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2),PieceColor.BLACK);
        }
        else{
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2),PieceColor.WHITE);
        }
        ChessBoard board = new ChessBoard(player1.getColor()); //creates Board with Player 1 on Top of the Board
        board.display();                                       //todo board needs the pieces(wasn't implemented yet)




        if(player1.getColor()==PieceColor.BLACK) {
            ChessPlayer currentPlayer = player2;
        }
        else{
            ChessPlayer currentPlayer = player1;
        }

    }





    public nextTurn(ChessPlayer currentPlayer, ChessPlayer player1, ChessPlayer player2){
        if(currentPlayer==player1){
            currentPlayer=player2;
        }
        else{
            currentPlayer=player1;
        }
    }



    //checks, if a king in check or checkmate
    public isChecked(){
        if(PieceSet.getColor() == currentPlayer.getColor){
            for(int i=0; i<16;i++){
                PieceSet[i] ==
            }
        }
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

    public int findSquare(ChessBoard[][] squares, Square position){
        for(int i = 0; i < squares.length; i++){
            for(int j = 0; j < squares.length; j++) {
                if(ChessBoard.getSquare(i, j) == position) {
                    ChessBoard.getSquare(i ,j);
                }
            }
        }
    }



}
