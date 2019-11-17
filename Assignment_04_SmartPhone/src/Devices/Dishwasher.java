package Devices;

import Interfaces.AllDevices;
import Interfaces.ProgrammableDevices;
import Interfaces.StationaryDevices;
import Util.SmartPhone;
import Util.MyThread;

public class Dishwasher implements ProgrammableDevices, AllDevices, StationaryDevices {

    private int deviceNr;
    private boolean isOn;

    public Dishwasher(){
        this.deviceNr = SmartPhone.DEVICE_NR;
        this.isOn = false;
        SmartPhone.DEVICE_NR++;
    }

    @Override
    public void start() {

    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }


    @Override
    public void interrupt() {

    }

    @Override
    public int getDeviceNr() {
        return deviceNr;
    }

    @Override
    public boolean getIsOn() {
        return false;
    }


    @Override
    public String toString(){
        return "| " + deviceNr + ". Access DISHWASHER      |";
    }

    @Override
    public void setTimer(int value, boolean undo) {
        //todo the timer is set depending on the current selected program
    }

    @Override
    public void checkTimer() {

    }

    @Override
    public long calculateTime() {
        return 0;
    }

    @Override
    public void selectProgram(int value, boolean undo) {

    }

    @Override
    public void displayPrograms() {

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
            System.out.println("|       5. interrupt        |");
            System.out.println("+---------------------------+");
            System.out.println("|          6. Back          |");
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
}
