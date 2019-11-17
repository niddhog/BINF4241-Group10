import java.util.Scanner;

public class OvenRunnable implements Runnable {

    public OvenRunnable() {

    }

    @Override
    public void run() {

        System.out.println("1 : Oven");
        System.out.println("2 : Microwave");
        System.out.println("3 : Dishwasher");
        System.out.println("4 : Washmachine");
        System.out.println("5 : Cleaning Robot");
        System.out.println("1 : Oven");
        System.out.println("2 : Microwave");
        System.out.println("3 : Dishwasher");
        System.out.println("4 : Washmachine");
        System.out.println("5 : Cleaning Robot");



        Timer mt1 = new Timer();                         // Behaviour of Thread 1

        Thread rt1;         // Thread 1

        long timestamp = System.currentTimeMillis();     // Pointer to current time for Thread 1

        while (true) {

            // Collecting User Input in an infinite loop
            System.out.println("Which Thread do you want to start?");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            // Basic control for command

            // command = 1 -> start the Thread 1
            if (command.equals("1") && !mt1.isRunning()) {
                rt1 = new Thread(mt1, "FirstThread");           // Creation of the Thread 1 assigning
                timestamp = System.currentTimeMillis();                // update of the pointer to current timestamp
                rt1.start();
            }

        }
    }
}
