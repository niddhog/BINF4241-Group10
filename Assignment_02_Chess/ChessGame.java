import java.util.Scanner;

//Init Player 1 and Player 2
//Set their colors
//evt. Log
//StartGame
//Check for Win Condition

public class ChessGame {
    public static void main(String[] args) {
        ChessPlayer player1 = new ChessPlayer(setPlayerName(1),setPlayerColor(1));
        if(player1.getColor()==PieceColor.WHITE){
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2),PieceColor.BLACK);
        }
        else{
            ChessPlayer player2 = new ChessPlayer(setPlayerName(2),PieceColor.WHITE);
        }
        ChessBoard board = new ChessBoard(player1.getColor()); //creates Board with Player 1 on Top of the Board
        board.display();
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
