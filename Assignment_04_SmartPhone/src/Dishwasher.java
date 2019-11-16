public class Dishwasher implements ProgrammableDevices, AllDevices, StationaryDevices {

    private int deviceNr;

    public Dishwasher(){
        this.deviceNr = SmartPhone.DEVICE_NR;
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
    public void displayFunctionMenu() {

    }

    @Override
    public String toString(){
        return "| " + deviceNr + ". Access DISHWASHER      |";
    }

    @Override
    public void setTimer(int value) {
        //todo the timer is set depending on the current selected program
    }

    @Override
    public void checkTimer() {

    }

    @Override
    public void selectProgram(int value) {

    }
}
