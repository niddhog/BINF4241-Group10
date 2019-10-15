import java.util.Scanner;

//Init Player 1 and Player 2
//Set their colors
//evt. Log
//StartGame
//Check for Win Condition

public class ChessGame {
    public static void main(String[] args) {
        ChessPlayer player1 = new ChessPlayer(setPlayerName(1));
        ChessPlayer player2 = new ChessPlayer(setPlayerName(2));
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
}
