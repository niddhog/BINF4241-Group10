import java.util.Scanner;

public class OvenRunnable implements Runnable {

    public OvenRunnable() {}

    @Override
    public void run() {
        Command[] slot;
        Oven oven = new Oven();
        OvenRemote remote = new OvenRemote();


        Timer mt1 = new Timer();
        Thread rt1 = null;         // Thread 1

        long timestamp = System.currentTimeMillis();     // Pointer to current time for Thread 1

        while (true) {

            System.out.println("1 : set timer");
            System.out.println("2 : set temperature");
            System.out.println("3 : set up a program");
            System.out.println("4 : start cooking");
            System.out.println("5 : check timer");
            System.out.println("6 : interrupt");
            System.out.println("7 : switch off");

            // Collecting User Input in an infinite loop
            System.out.println("Which Thread do you want to start?");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            // Basic control for command

            // command = 1 -> set timer
            if(command.equals("1")){
                System.out.println("How long should it be cooked (in seconds)?");
                Scanner duration = new Scanner(System.in);
                int clock = Integer.parseInt(duration.nextLine());
                remote.setCommand(new setTimerOven(oven, clock*1000));
                remote.pressButton();
                mt1 = new Timer(oven.getTimer());
            }

            // command = 2 -> set temperature
            else if (command.equals("2")){
                System.out.println("Please adjust the temperature in degrees.");
                Scanner duration = new Scanner(System.in);
                int degrees = Integer.parseInt(duration.nextLine());
                remote.setCommand(new setTemperatureOven(oven, degrees));
                remote.pressButton();
            }

            // command = 3 -> set up program
            else if(command.equals("3")) {
                while (true) {
                    System.out.println("1 : grill \n2 : ventilated \n3 : lower heat only \n4 : upper and lower heat");
                    System.out.println("Please choose the program by access a number.");
                    Scanner duration = new Scanner(System.in);
                    int program = Integer.parseInt(duration.nextLine());
                    if (1 <= program && program <= 4) {
                        remote.setCommand(new setCurrentProgramOven(oven, oven.getProgram()[program-1]));
                        break;
                    } else {
                        System.out.println("No valid program chosen.");
                    }
                }
            }

            if(command.equals("4")&& (!mt1.isRunning() && oven.getTemperature() > 0 && oven.getTimer() > 0
                    && oven.getCurrentProgram() != null) || !oven.isInterrupted()) {

                    // command = 4 -> start program{
                        rt1 = new Thread(mt1);           // Creation of the Thread 1 assigning
                        timestamp = System.currentTimeMillis();                // update of the pointer to current timestamp
                        rt1.start();
                    }
                /*
                    // command = stop 1 -> stop of Thread 1
                    else if (command.equals("stop 1") && mt1.isRunning()) {
                        /*
                         * deleting the behaviour to destroy the hidden state of variables. If the thread is stopped before his
                         * natural death, the variable running will be true. You can also create a method stop() in the
                         * runnable object that change the state to false and call it instead of destroying the runnable
                         * object.
                         *
                        mt1 = null;
                        rt1 = null;
                        float time = System.currentTimeMillis() - timestamp;     // Calculation of elapsed time: (end - start)
                        System.out.println("Elapsed time 1: " + time);
                        mt1 = new Timer();                           // recreation of the deleted behaviour objects
                        rt1 = new Thread(mt1, "theThread");      // recreation of deleted thread


                    }*/


            // command = 5 -> check timer
            else if(command.equals("5")){
                remote.setCommand(new setCheckTimerOven(oven, (int) timestamp));
                remote.pressButton();
                remote.setCommand(new getCheckTimerOven(oven));
                remote.pressButton();
                System.out.println(oven.getCheckTimer());
            }


            // command = 6 -> interrupt
            else if (command.equals("6") && mt1.isRunning()){
                remote.setCommand(new setInterruptedOven(oven, true));
                rt1.interrupt();

            }


            // command = 7 -> switch off
            else if (command.equals("7")){
                oven.switchOff();
                break;                      //run is over, so it returns to the Main device
            }

        }
    }
}
