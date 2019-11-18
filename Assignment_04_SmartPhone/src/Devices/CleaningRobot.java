package Devices;

import Interfaces.AllDevices;
import Interfaces.RoboticDevices;
import Interfaces.TimeableDevices;
import Util.*;

public class CleaningRobot implements RoboticDevices, AllDevices, TimeableDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int deviceNr;
    private boolean isOn;
    private int cleaningCompletion;
    public int batteryStatus;

    private roboTimeThread roboTimerThread;  //TIMER
    private Thread rt;
    private long elapsed;
    private roboBatteryThread batteryDischargeThread;  //DECREASE BATTERY
    private Thread rt2;
    private roboProgressThread completionThread;  //INCREASE PROGRESSION
    private Thread rt3;
    private RoboRechargeThread batteryChargeThread;  //INCREASE BATTERY
    private Thread rt4;

    public CleaningRobot(){
        this.timer = -1;
        this.isOn = false;
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
        this.roboTimerThread = new roboTimeThread();
        this.batteryDischargeThread = new roboBatteryThread();
        this.completionThread = new roboProgressThread();
        this.batteryChargeThread = new RoboRechargeThread();
        this.elapsed = System.currentTimeMillis();
        cleaningCompletion = 90;
        batteryStatus = 100;
    }


    @Override
    public void start() {
        if(roboTimerThread.isRunning()){  //Robo is not at station
            System.out.println("The Cleaning Robot is currently not at the charging Station and can't start a new" +
                    "cleaning Task! Time left: " + calculateTime() +"s; Completiton: " + calculateCompletion() +
                    "%; Battery: " + calculateBattery() + "%.");
        }
        else if(batteryChargeThread.isRunning()){  //Robo is not fully charged
            System.out.println("The Battery is not fully charged yet");
        }
        else if(timer <= 0){
            System.out.println("Set a timer first!");
        }
        else{  //Start the process
            roboTimerThread.setTime(timer);
            rt = new Thread(roboTimerThread, "timerThread");

            batteryDischargeThread.setTime(batteryStatus);
            rt2 = new Thread(batteryDischargeThread, "batteryDThread");

            completionThread.setTime(100 - cleaningCompletion);
            rt3 = new Thread(completionThread, "completionThread");

            elapsed = System.currentTimeMillis();  //at this time the Thread started
            rt.start();
            rt2.start();
            rt3.start();
            System.out.println("The Cleaning Robot has started cleaning!");
        }
    }

    @Override
    public void checkBatteryStatus() {
        if(batteryDischargeThread.isRunning()){
            System.out.println("The Cleaning Robot Battery is at " + calculateBattery() + "%!");
        }
        else{
            System.out.println("The Cleaning Robot is currently being recharged at the Station! Battery at: ");
            //Todo print Current Charge Status
        }
    }


    @Override
    public void checkCompletion() {
        if (completionThread.isRunning()) {
            System.out.println("The Cleaning Robot has cleaned " + calculateCompletion() + "%!");
        } else {
            System.out.println(cleaningCompletion + "% has been cleaned!");
        }
    }


    @Override
    public void checkBatteryCharging() {
        if(roboTimerThread.isRunning()){  //Robo is not at station
            System.out.println("The Robo is currently not at the charging Station!");
        }
        else{
            if(batteryStatus == 100){
                System.out.println("The Battery is fully Charged!");
            }
            else{
                System.out.println("The battery is currently at: " + calculateBatteryCharge() + "%!");
            }
        }
    }


    @Override
    public void continueWork() {
        if(timer<=0){
            timer = 100 - cleaningCompletion;
        }
        this.start();
    }

    @Override
    public void interrupt() {
        if(!completionThread.isRunning()){
            cleaningCompletion = 0;
        }
        else{
            cleaningCompletion = (int)calculateCompletion();
        }

        if(!batteryDischargeThread.isRunning()){
            batteryStatus = 0;
        }
        else{
            batteryStatus = (int)calculateBattery();
        }

        if(roboTimerThread.isRunning() || completionThread.isRunning() || batteryDischargeThread.isRunning()){  //Timer has not yet expired
            roboTimerThread = null;
            rt.interrupt();
            rt = null;
            roboTimerThread = new roboTimeThread();
            rt = new Thread(roboTimerThread, "timerThread");
            timer = -1;  //Timer always gets reset if interrupted

            batteryDischargeThread = null;
            rt2.interrupt();
            rt2 = null;
            batteryDischargeThread = new roboBatteryThread();
            rt2 = new Thread(batteryDischargeThread, "batteryDThread");

            completionThread = null;
            rt3.interrupt();
            rt3 = null;
            completionThread = new roboProgressThread();
            rt3 = new Thread(batteryDischargeThread, "completionThread");

            elapsed = System.currentTimeMillis();  //at this time the Thread for Recharge Starts
            batteryChargeThread.setTime(100-batteryStatus);
            rt4 = new Thread(batteryChargeThread, "batteryCThread");
            rt4.start();

            System.out.println("The cleaning Robot has arrived at station and will start recharging");
        }
        else{
            System.out.println("The Cleaning Robot is currently at the Station!");
        }
    }

    @Override
    public void setTimer(int value, boolean undo) {
        if(roboTimerThread.isRunning()){  //Robo is not at station
            System.out.println("Wait for the Robo to return to Station before setting a new Timer!");
        }
        else {
            if(value<=0){
                if(undo){
                    timer = value;
                }
                else{
                    System.out.println("Please enter a value greater than 0");
                }
            }
            else{
                System.out.println("The Robo Timer was set to: " + value + " seconds!");
                timer = value;
            }
        }
    }

    @Override
    public void checkTimer() {
        //todo check to see when robo needs to go back to charging
    }

    @Override
    public long calculateTime() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = (tempMilli - elapsed) / 1000;  //Difference in Seconds
        return timer - timeDif;
    }

    public long calculateCompletion() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = ((tempMilli - elapsed) / 719);  //Difference in Seconds
        return cleaningCompletion + timeDif;
    }

    public long calculateBattery() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = ((tempMilli - elapsed) / 1221);  //Difference in Seconds
        return batteryStatus - timeDif;
    }


    public long calculateBatteryCharge() {
        long tempMilli = System.currentTimeMillis();
        long timeDif = ((tempMilli - elapsed) / 250);  //Difference in Seconds
        return batteryStatus + timeDif;
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
    public void displayFunctionMenu() {
        System.out.print("\n");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("|    CLEANING ROBOT MENU    |");
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("+---------------------------+");
        System.out.println("|       0. set Timer        |");
        System.out.println("+---------------------------+");
        System.out.println("|     1. start cleaning     |");
        System.out.println("+---------------------------+");
        System.out.println("| 2. check cleaning progress|");
        System.out.println("+---------------------------+");
        System.out.println("|  3. check battery status  |");
        System.out.println("+---------------------------+");
        System.out.println("|  4. check charging status |");
        System.out.println("+---------------------------+");
        System.out.println("|    5. complete cleaning   |");
        System.out.println("+---------------------------+");
        System.out.println("|       6. Interrupt        |");
        System.out.println("+---------------------------+");
        System.out.println("|          7. Back          |");
        System.out.println("+---------------------------+");
        System.out.print("\n");
    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access CLEANING ROBOT  |";
    }

    public void createNewRechargeThread(){
        batteryChargeThread = null;
        rt4.interrupt();
        rt4 = null;
        batteryChargeThread = new RoboRechargeThread();
        rt4 = new Thread(batteryChargeThread, "batteryRThread");
    }
}
