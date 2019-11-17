package Devices;

import Interfaces.AllDevices;
import Interfaces.HeatBasedDevices;
import Interfaces.StationaryDevices;
import Interfaces.TimeableDevices;
import Util.SmartPhone;
import Util.MyThread;

public class MicroWave implements HeatBasedDevices, AllDevices, StationaryDevices, TimeableDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int temperature;  //Temperature in degree celsius
    private int deviceNr;
    private boolean isOn;
    private MyThread microThread;
    private Thread rt;
    private long elapsed;

    public MicroWave(){
        this.timer = -1;
        this.temperature = -1;
        this.isOn = false;
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
        this.microThread = new MyThread();
        this.elapsed = System.currentTimeMillis();
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
        microThread = null;
        rt = null;
        microThread = new MyThread();
        rt = new Thread(microThread, "microThread");
        System.out.println("MicroWave SHUT DOWN!");
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
            System.out.println("The Microwave Timer was set to: " + value + " seconds!");
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
                System.out.println("Temperature can't fall below 0 in this Microwave!");
            }
            else{
                System.out.println("The Microwave Temperature was set to: " + value + " Degrees Celsius!");
                temperature = value;
            }
        }
    }

    @Override
    public void start() {
        if(microThread.isRunning()){
            System.out.println("The Microwave is already running! Time left for cooking is: " + calculateTime() + "!");
        }
        else{  //Not all Parameters have been set
            if(temperature==-1 || timer == -1){
                System.out.print("Microwave can't start. Please first set the ");
                if(temperature == -1){
                    System.out.print("[Temperature] ");
                }
                if(timer == -1){
                    System.out.print("[Timer] ");
                }
                System.out.print("!");
            }
            else{  //Create a new Thread
                microThread.setTime(timer);
                rt = new Thread(microThread, "microThread");
                elapsed = System.currentTimeMillis();  //at this time the Thread started
                rt.start();
                System.out.println("The Microwave has started!");
            }
        }
    }

    @Override
    public void checkTimer() {
        if(microThread.isRunning()){  //Cooking Thread is currently running
            System.out.println("Time left for baking is: " + calculateTime() + "!");
        }
        else{
            System.out.println("Microwave Timer currently set to: " + timer);
        }
    }

    @Override
    public void interrupt() {
        if(microThread.isRunning()){  //Cooking Thread is currently running
            microThread = null;
            rt = null;
            microThread = new MyThread();
            rt = new Thread(microThread, "microThread");
            temperature = -1;
            timer = -1;
            System.out.println("The Microwave has stopped running!");
        }
        else{
            System.out.println("The Microwave is currently not running. Please start it first!");
        }
    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access MICROWAVE       |";
    }

    @Override
    public void displayFunctionMenu() {
        if(isOn){
            System.out.print("\n");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("|       MICROWAVE MENU      |");
            System.out.println("|||||||||||||||||||||||||||||");
            System.out.println("+---------------------------+");
            System.out.println("|       0. switch off       |");
            System.out.println("+---------------------------+");
            System.out.println("|       1. set timer        |");
            System.out.println("+---------------------------+");
            System.out.println("|    2. set temperature     |");
            System.out.println("+---------------------------+");
            System.out.println("|     3. start baking       |");
            System.out.println("+---------------------------+");
            System.out.println("|      4. check timer       |");
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
            System.out.println("|       MICROWAVE MENU      |");
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

}
