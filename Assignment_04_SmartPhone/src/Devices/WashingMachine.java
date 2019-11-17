package Devices;

import Interfaces.*;
import Util.SmartPhone;
import Util.MyThread;

public class WashingMachine implements ProgrammableDevices, AllDevices, StationaryDevices, DegreeSelectionDevices {

    private int deviceNr;
    private boolean isOn;
    private int timer;
    private Programs program;
    private DegreeScale degree;
    private int temperature;
    private enum Programs{
        DOUBLE_RINSE, INTENSE, SPEED, SPIN
    }
    private enum DegreeScale{
        THIRTY, FOURTY, SIXTY, NINTY
    }
    private MyThread washingmachineThread;
    private Thread rt;
    private long elapsed;

    public WashingMachine(){
        this.deviceNr = SmartPhone.DEVICE_NR;
        this.isOn = false;
        SmartPhone.DEVICE_NR++;
        this.timer = -1;
        this.program = null;
        this.degree = null;
        this.washingmachineThread = new MyThread();
        this.elapsed = System.currentTimeMillis();
        this.temperature = -1;
    }

    @Override
    public void start() {
        if(washingmachineThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("The Washing Machine is already running! Time left for cooking is: "
                    + calculateTime() + "!");
        }
        else if(program == null || degree == null){
            System.out.print("The Washing Machine can't start as long as you haven't chosen ");
            if(program == null){
                System.out.print("[Program] ");
            }
            if(degree == null){
                System.out.print("[Degree] ");
            }
        }
        else{
            timer = getProgramTime();
            washingmachineThread.setTime(timer);
            rt = new Thread(washingmachineThread, "washingmachineThread");
            elapsed = System.currentTimeMillis();  //at this time the Thread started
            rt.start();
            System.out.println("The Washing Machine has started!");
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
        degree = null;
        washingmachineThread = null;
        rt = null;
        washingmachineThread = new MyThread();
        rt = new Thread(washingmachineThread, "washingmachineThread");
        System.out.println("Washing Machine SHUT DOWN!");
    }

    @Override
    public void interrupt() {
        if(washingmachineThread.isRunning()){  //Cooking Thread is currently running
            washingmachineThread = null;
            rt = null;
            washingmachineThread = new MyThread();
            rt = new Thread(washingmachineThread, "washingmachineThread");
            timer = -1;
            program = null;
            degree = null;
            System.out.println("The Washing Machine has stopped running!");
        }
        else{
            System.out.println("The Washing Machine is currently not running. Please start it first!");
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
        return "| " + deviceNr + ". Access WASHING MACHINE |";
    }


    @Override
    public long calculateTime() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = (tempMilli - elapsed) / 1000;  //Difference in Seconds
        return timer - timeDif;
    }

    @Override
    public void selectProgram(int value, boolean undo) {
        if(undo){
            program = null;
        }
        else{
            try {
                if(value == 0){
                    program = Programs.DOUBLE_RINSE;
                }else if(value == 1){
                    program = Programs.INTENSE;
                }else if(value == 2){
                    program = Programs.SPEED;
                }else if(value == 3){
                    program = Programs.SPIN;
                }else{
                    program = null;
                }
                System.out.println("Washing Machine program set to " + program.toString() + "!");
            }catch (NullPointerException e){
                System.out.println("This Program is not available! Program was set to NULL");
            }
        }
    }

    @Override
    public void displayPrograms() {
        System.out.print("\n");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("|  WASHING MACHINE PROGRAMS  |");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("+---------------------------+");
        System.out.println("|        0. intense         |");
        System.out.println("+---------------------------+");
        System.out.println("|     1. double rinse       |");
        System.out.println("+---------------------------+");
        System.out.println("|     2. speed of light     |");
        System.out.println("+---------------------------+");
        System.out.println("|         3. spin           |");
        System.out.println("+---------------------------+");
        System.out.print("\n");
    }

    @Override
    public void displayFunctionMenu() {
        if(isOn){
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|    WASHING MACHINE MENU   |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch off       |");
            System.out.println("+---------------------------+");
            System.out.println("|         1. start          |");
            System.out.println("+---------------------------+");
            System.out.println("|     2. select Degrees     |");
            System.out.println("+---------------------------+");
            System.out.println("|     3. select Program     |");
            System.out.println("+---------------------------+");
            System.out.println("|       4. interrupt        |");
            System.out.println("+---------------------------+");
            System.out.println("|          5. back          |");
            System.out.println("+---------------------------+");
            System.out.print("\n");
        }
        else{
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|    WASHING MACHINE MENU   |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch on        |");
            System.out.println("+---------------------------+");
            System.out.println("|          1. back          |");
            System.out.println("+---------------------------+");
            System.out.print("\n");
        }
    }

    private int getProgramTime(){
        if(program == Programs.DOUBLE_RINSE){
            return 350;
        }
        else if(program == Programs.INTENSE){
            return 400;
        }
        else if(program == Programs.SPEED){
            return 5;
        }
        else if(program == Programs.SPIN){
            return 600;
        }
        return -1;
    }

    @Override
    public void selectDegree(int value, boolean undo) {
        if(undo){
            degree = null;
        }
        else{
            try {
                if(value == 0){
                    degree = DegreeScale.THIRTY;
                }else if(value == 1){
                    degree = DegreeScale.FOURTY;
                }else if(value == 2){
                    degree = DegreeScale.SIXTY;
                }else if(value == 3){
                    degree = DegreeScale.NINTY;
                }else{
                    degree = null;
                }
                System.out.println("Degrees set to " + degree.toString() + "!");
            }catch (NullPointerException e){
                System.out.println("This Degree Value is not available! Degree was set to NULL");
            }
        }
    }

    @Override
    public void displayDegreeSelection() {
        System.out.print("\n");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("|  SELECT DEGREES CELSIUS   |");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("+---------------------------+");
        System.out.println("|          0. 30° C         |");
        System.out.println("+---------------------------+");
        System.out.println("|          1. 40° C         |");
        System.out.println("+---------------------------+");
        System.out.println("|          2. 60° C         |");
        System.out.println("+---------------------------+");
        System.out.println("|          3. 90° C         |");
        System.out.println("+---------------------------+");
        System.out.print("\n");
    }
}
