import java.util.Scanner;

//Init Player 1 and Player 2
//Set their colors
//evt. Log
//StartGame
//Check for Win Condition

public class ChessGame {
    public static void main(String[] args) {
        String p2Color;
        ChessPlayer player1 = new ChessPlayer(setPlayerName(1),setPlayerColor(1));
        if(player1.getColor()=="W"){
            p2Color ="B";
        }
        else{
            p2Color ="W";
        }
        ChessPlayer player2 = new ChessPlayer(setPlayerName(2),p2Color);
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


    public static String setPlayerColor(int p){
        Scanner colorObject = new Scanner(System.in);
        while(true){
            System.out.print("Please enter the Color(W/B) of Player " + p + ": ");
            String color = colorObject.nextLine();
            if(color.isEmpty()){
                System.out.println("You did not enter any color, please input W or B...");
            }
            else if(color.equals("B") || color.equals("W")){
                return color;
            }
            else{
                System.out.println("Your input is invalid, please enter W or B...");
            }
        }
    }
}
