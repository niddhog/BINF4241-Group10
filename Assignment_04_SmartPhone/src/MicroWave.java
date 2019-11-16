public class MicroWave implements HeatBasedDevices, AllDevices, StationaryDevices {

    private int timer;  //Variable holds the timer value in seconds
    private int temperature;  //Temperature in degree celsius
    private int deviceNr;

    public MicroWave(){
        this.timer = 0;
        this.temperature = 0;
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
    public void displayFunctionMenu() {

    }

    @Override
    public void setTimer(int value) {

    }

    @Override
    public void setTemperature(int value) {

    }

    @Override
    public void start() {

    }

    @Override
    public void checkTimer() {

    }

    @Override
    public void interrupt() {

    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access MICROWAVE       |";
    }

}
