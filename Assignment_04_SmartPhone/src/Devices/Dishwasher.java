package Devices;

import Interfaces.AllDevices;
import Interfaces.ProgrammableDevices;
import Interfaces.StationaryDevices;
import Util.SmartPhone;
import Util.MyThread;

public class Dishwasher implements ProgrammableDevices, AllDevices, StationaryDevices {

    private int deviceNr;
    private boolean isOn;
    private int timer;  //Variable holds the timer value in seconds
    private Programs program;
    private enum Programs{
        Glasses, Plates, Pans, Mixed
    }
    private MyThread dishwasherThread;
    private Thread rt;
    private long elapsed;

    public Dishwasher(){
        this.deviceNr = SmartPhone.DEVICE_NR;
        this.isOn = false;
        SmartPhone.DEVICE_NR++;
        this.timer = -1;
        this.program = null;
        this.dishwasherThread = new MyThread();
        this.elapsed = System.currentTimeMillis();
    }

    @Override
    public void start() {
        if(dishwasherThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("The Dishwasher is already running! Time left for cooking is: " + calculateTime() + "!");
        }
        else if(program == null){
            System.out.println("The Dishwasher can't start as long as you haven't chosen a program!");
        }
        else{
            timer = getProgramTime();
            dishwasherThread.setTime(timer);
            rt = new Thread(dishwasherThread, "dishwasherThread");
            elapsed = System.currentTimeMillis();  //at this time the Thread started
            rt.start();
            System.out.println("The Dishwasher has started!");
        }
    }

    @Override
    public void switchOn() {
        isOn = true;
    }

    @Override
    public void switchOff() {
        isOn = false;
        timer = -1;
        program = null;
        dishwasherThread = null;
        rt = null;
        dishwasherThread = new MyThread();
        rt = new Thread(dishwasherThread, "dishwasherThread");
        System.out.println("Dishwasher SHUT DOWN!");
    }


    @Override
    public void interrupt() {
        if(dishwasherThread.isRunning()){  //Cooking Thread is currently running
            dishwasherThread = null;
            rt = null;
            dishwasherThread = new MyThread();
            rt = new Thread(dishwasherThread, "dishwasherThread");
            timer = -1;
            program = null;
            System.out.println("The Dishwasher has stopped running!");
        }
        else{
            System.out.println("The Dishwasher is currently not running. Please start it first!");
        }
    }

    @Override
    public void checkTimer() {
        if(dishwasherThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("Time left for dish-washing is: " + calculateTime() + "!");
        }
        else{
            System.out.println("Dishwasher Timer currently set to: " + getProgramTime());
        }
    }

    @Override
    public void selectProgram(int value, boolean undo) {
        if(undo){
            program = null;
        }
        else{
            try {
                if(value == 0){
                    program = Programs.Glasses;
                }else if(value == 1){
                    program = Programs.Plates;
                }else if(value == 2){
                    program = Programs.Pans;
                }else if(value == 3){
                    program = Programs.Mixed;
                }else{
                    program = null;
                }
                System.out.println("Dishwasher program set to " + program.toString() + "!");
            }catch (NullPointerException e){
                System.out.println("This Program is not available! Program was set to NULL");
            }
        }
    }

    @Override
    public int getDeviceNr() {
        return deviceNr;
    }

    @Override
    public boolean getIsOn() {
        return isOn;
    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access DISHWASHER      |";
    }

    @Override
    public void displayPrograms() {
        System.out.print("\n");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("|    DISHWASHER PROGRAMS    |");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("+---------------------------+");
        System.out.println("|         0. glasses        |");
        System.out.println("+---------------------------+");
        System.out.println("|         1. plates         |");
        System.out.println("+---------------------------+");
        System.out.println("|         2. pans           |");
        System.out.println("+---------------------------+");
        System.out.println("|         3. mixed          |");
        System.out.println("+---------------------------+");
        System.out.print("\n");
    }

    @Override
    public void displayFunctionMenu() {
        if(isOn){
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|      DISHWASHER MENU      |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch off       |");
            System.out.println("+---------------------------+");
            System.out.println("|         1. start          |");
            System.out.println("+---------------------------+");
            System.out.println("|     2. choose Program     |");
            System.out.println("+---------------------------+");
            System.out.println("|      3. check timer       |");
            System.out.println("+---------------------------+");
            System.out.println("|       4. interrupt        |");
            System.out.println("+---------------------------+");
            System.out.println("|          5. Back          |");
            System.out.println("+---------------------------+");
            System.out.print("\n");
        }
        else{
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|      DISHWASHER MENU      |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch on        |");
            System.out.println("+---------------------------+");
            System.out.println("|          1. back          |");
            System.out.println("+---------------------------+");
            System.out.print("\n");
        }
    }

    @Override
    public long calculateTime() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = (tempMilli - elapsed) / 1000;  //Difference in Seconds
        return timer - timeDif;
    }


    private int getProgramTime(){
        if(program == Programs.Glasses){
            return 35;
        }
        else if(program == Programs.Plates){
            return 40;
        }
        else if(program == Programs.Pans){
            return 45;
        }
        else if(program == Programs.Mixed){
            return 60;
        }
        return -1;
    }
}
