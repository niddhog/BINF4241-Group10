package Devices;

import Interfaces.AllDevices;
import Interfaces.HeatBasedDevices;
import Interfaces.ProgrammableDevices;
import Interfaces.StationaryDevices;
import Util.SmartPhone;
import Util.MyThread;

public class WashingMachine implements ProgrammableDevices, AllDevices, StationaryDevices, HeatBasedDevices {

    private int deviceNr;
    private boolean isOn;

    public WashingMachine(){
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
        return "| " + deviceNr + ". Access WASHING MACHINE |";
    }

    @Override
    public void setTimer(int value, boolean undo) {
        //todo timer is based on the program
    }

    @Override
    public void checkTimer() {
        //todo not mentioned in the Assignment but makes sense obviously
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
    public void setTemperature(int value, boolean undo) {

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
            System.out.println("|      3. select Modus      |");
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
}
