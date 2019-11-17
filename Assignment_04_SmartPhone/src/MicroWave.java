public class MicroWave implements HeatBasedDevices, AllDevices, StationaryDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int temperature;  //Temperature in degree celsius
    private int deviceNr;
    private boolean isOn;

    public MicroWave(){
        this.timer = 0;
        this.temperature = 0;
        this.isOn = false;
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
    }

    @Override
    public void switchOn() {
        System.out.println("Microwave is ON");
    }

    @Override
    public void switchOff() {
        System.out.println("Microwave is OFF");
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
    public void setTimer(int value, boolean undo) {

    }

    @Override
    public void setTemperature(int value, boolean undo) {

    }

    @Override
    public void start() {

    }

    @Override
    public void checkTimer() {

    }

    @Override
    public long calculateTime() {
        return 0;
    }

    @Override
    public void interrupt() {

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

}
