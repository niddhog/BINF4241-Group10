import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        OvenRunnable ovenThread = new OvenRunnable();
        MicrowaveRunnable microwaveThread = new MicrowaveRunnable();
        DishwasherRunnable dishwasherThread = new DishwasherRunnable();
        WashMachineRunnable washMachineThread = new WashMachineRunnable();
        CleaningRobotRunnable cleaningRobotThread = new CleaningRobotRunnable();

        while(true){
            System.out.println("1 : Oven");
            System.out.println("2 : Microwave");
            System.out.println("3 : Dishwasher");
            System.out.println("4 : Washmachine");
            System.out.println("5 : Cleaning Robot");

            System.out.println("Which device do you want to start? \n Choose a number to access the device.");
            Scanner scanner = new Scanner(System.in);
            String log = scanner.nextLine();

            if (log.equals("1")) {
                ovenThread.run();
            }
            else if(log.equals("2")) {
                microwaveThread.run();
            }
            else if(log.equals("3")) {
                dishwasherThread.run();
            }
            else if(log.equals("4")) {
                washMachineThread.run();
            }
            else if(log.equals("5")) {
                cleaningRobotThread.run();
            }
            else{
                System.out.println("Your choice was invalid.");
            }
        }

    }
}
