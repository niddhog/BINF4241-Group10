package Devices;//This is the receiver: Oven

import Interfaces.*;
import Util.SmartPhone;
import Util.MyThread;

public class Oven implements HeatBasedDevices, AllDevices, StationaryDevices, ProgrammableDevices, TimeableDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int temperature;  //Temperature in degree celsius
    private int deviceNr;
    private boolean isOn;
    private Programs program;
    private enum Programs{
        VENTILATE, GRILL, STEAM, INCINERATE
    }
    private MyThread ovenThread;
    private Thread rt;
    private long elapsed;

    public Oven(){
        this.timer = -1;
        this.temperature = -1;
        this.isOn = false;
        this.program = null;
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
        this.ovenThread = new MyThread();
        this.elapsed = System.currentTimeMillis();
    }

    @Override
    public void selectProgram(int value, boolean undo) {
        if(undo){
            program = null;
        }
        else{
            try {
                if(value == 0){
                    program = Programs.VENTILATE;
                }else if(value == 1){
                    program = Programs.GRILL;
                }else if(value == 2){
                    program = Programs.STEAM;
                }else if(value == 3){
                    program = Programs.INCINERATE;
                }else{
                    program = null;
                }
                System.out.println("Oven program set to " + program.toString() + "!");
            }catch (NullPointerException e){
                System.out.println("This Program is not available! Program was set to NULL");
            }
        }
    }


    @Override
    public void switchOn() {
        isOn = true;
    }

    @Override
    public void switchOff() {
        isOn = false;
        temperature = -1;
        timer = -1;
        program = null;
        ovenThread = null;
        rt = null;
        ovenThread = new MyThread();
        rt = new Thread(ovenThread, "ovenThread");
        System.out.println("Oven SHUT DOWN!");
    }


    @Override
    public int getDeviceNr() {
        return deviceNr;
    }

    @Override
    public void setTimer(int value, boolean undo) {
        if(value<=0){
            if(undo){
                timer = value;
            }
            else{
                System.out.println("Please enter a value greater than 0");
            }
        }
        else{
            System.out.println("The Oven Timer was set to: " + value + " seconds!");
            timer = value;
        }
    }

    @Override
    public void setTemperature(int value, boolean undo) {
        if(undo){
            temperature = -1;
        }
        else{
            if(value<=0){
                System.out.println("Temperature can't fall below 0 in this Oven!");
            }
            else{
                System.out.println("The Oven Temperature was set to: " + value + " Degrees Celsius!");
                temperature = value;
            }
        }
    }

    @Override
    public void start() {
        if(ovenThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("The Oven is already running! Time left for cooking is: " + calculateTime() + "!");
        }
        else{  //Not all Parameters have been set
            if(temperature==-1 || timer == -1 || program == null){
                System.out.print("Oven can't start. Please first set the ");
                if(temperature == -1){
                    System.out.print("[Temperature] ");
                }
                if(timer == -1){
                    System.out.print("[Timer] ");
                }
                if(program == null){
                    System.out.print("[Program] ");
                }
                System.out.print("!");
            }
            else{  //Create a new Thread
                ovenThread.setTime(timer);
                rt = new Thread(ovenThread, "ovenThread");
                elapsed = System.currentTimeMillis();  //at this time the Thread started
                rt.start();
                System.out.println("The Oven has started!");
            }
        }
    }

    @Override
    public void checkTimer() {
        if(ovenThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("Time left for cooking is: " + calculateTime() + "!");
        }
        else{
            System.out.println("Oven Timer currently set to: " + timer);
        }
    }


    @Override
    public void interrupt() {
        if(ovenThread.isRunning()){  //Cooking Thread is currently running
            ovenThread = null;
            rt = null;
            ovenThread = new MyThread();
            rt = new Thread(ovenThread, "ovenThread");
            temperature = -1;
            timer = -1;
            program = null;
            System.out.println("The Oven has stopped running!");
        }
        else{
            System.out.println("The Oven is currently not running. Please start it first!");
        }
    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access OVEN            |";
    }

    @Override
    public boolean getIsOn(){
        return isOn;
    }

    @Override
    public void displayFunctionMenu(){
        if(isOn){
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|         OVEN MENU         |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch off       |");
            System.out.println("+---------------------------+");
            System.out.println("|       1. set Timer        |");
            System.out.println("+---------------------------+");
            System.out.println("|    2. set Temperature     |");
            System.out.println("+---------------------------+");
            System.out.println("|     3. select Program     |");
            System.out.println("+---------------------------+");
            System.out.println("|     4. start Cooking      |");
            System.out.println("+---------------------------+");
            System.out.println("|      5. check Timer       |");
            System.out.println("+---------------------------+");
            System.out.println("|       6. interrupt        |");
            System.out.println("+---------------------------+");
            System.out.println("|          7. back          |");
            System.out.println("+---------------------------+");
            System.out.print("\n");
        }
        else{
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|         OVEN MENU         |");
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
    public void displayPrograms() {
        System.out.print("\n");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("|       OVEN PROGRAMS       |");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("+---------------------------+");
        System.out.println("|       0. ventilate        |");
        System.out.println("+---------------------------+");
        System.out.println("|         1. grill          |");
        System.out.println("+---------------------------+");
        System.out.println("|         2. steam          |");
        System.out.println("+---------------------------+");
        System.out.println("|       3. incinerate       |");
        System.out.println("+---------------------------+");
        System.out.print("\n");
    }

    @Override
    public long calculateTime() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = (tempMilli - elapsed) / 1000;  //Difference in Seconds
        return timer - timeDif;
    }

}
