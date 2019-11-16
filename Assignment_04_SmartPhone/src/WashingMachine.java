public class WashingMachine implements ProgrammableDevices, AllDevices, StationaryDevices, HeatBasedDevices {

    private int deviceNr;

    public WashingMachine(){
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
        return "| " + deviceNr + ". Access WASHING MACHINE |";
    }

    @Override
    public void setTimer(int value) {
        //todo timer is based on the program
    }

    @Override
    public void checkTimer() {
        //todo not mentioned in the Assignment but makes sense obviously
    }

    @Override
    public void selectProgram(int value) {

    }

    @Override
    public void setTemperature(int value) {

    }
}
