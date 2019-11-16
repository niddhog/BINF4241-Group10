//This is the receiver Oven

public class Oven implements HeatBasedDevices, AllDevices, StationaryDevices,ProgrammableDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int temperature;  //Temperature in degree celsius
    private int deviceNr;
    private boolean isOn;
    private Programs program;
    private enum Programs{
        VENTILATE, GRILL, STEAM, INCINERATE
    }

    public Oven(){
        this.timer = -1;
        this.temperature = -1;
        this.isOn = false;
        this.program = null;
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
    }

    @Override
    public void selectProgram(int value) {
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
    }

    @Override
    public void switchOn() {
        isOn = true;
    }

    @Override
    public void switchOff() {
        isOn = false;
        //todo reset States of the Oven when it is switched off
    }


    @Override
    public int getDeviceNr() {
        return deviceNr;
    }

    @Override
    public void setTimer(int value) {
        timer = value;
    }

    @Override
    public void setTemperature(int value) {
        temperature = value;
    }

    @Override
    public void start() {
        if(temperature==-1 || timer == -1 || program == null){
            System.out.println("Oven can't be started before you set a Temperature, the Timer and a program");
        }
        else{
            //todo start a cooking thread that counts down the timer
        }
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer at: " + timer);
    }

    @Override
    public void interrupt() {
        //todo only possible if oven is running. Resets stats (Timer = -1, Temperature = -1, Program = null"
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
            System.out.println("|       0. switch off        |");
            System.out.println("+---------------------------+");
            System.out.println("|       1. set timer        |");
            System.out.println("+---------------------------+");
            System.out.println("|    2. set temperature     |");
            System.out.println("+---------------------------+");
            System.out.println("|     3. start cooking      |");
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

}
