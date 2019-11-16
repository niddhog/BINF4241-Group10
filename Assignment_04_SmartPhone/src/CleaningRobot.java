public class CleaningRobot implements RoboticDevices, AllDevices {

    private int deviceNr;

    public CleaningRobot(){
        this.deviceNr = SmartPhone.DEVICE_NR;
        SmartPhone.DEVICE_NR++;
    }


    @Override
    public void start() {

    }

    @Override
    public void checkBatteryStatus() {

    }

    @Override
    public void checkBatteryCharging() {

    }

    @Override
    public void checkCompletion() {

    }

    @Override
    public void continueWork() {

    }

    @Override
    public void interrupt() {

    }

    @Override
    public void setTimer(int value) {

    }

    @Override
    public void checkTimer() {
        //todo check to see when robo needs to go back to charging
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
        return "| " + deviceNr + ". Access CLEANING ROBOT  |";
    }
}
