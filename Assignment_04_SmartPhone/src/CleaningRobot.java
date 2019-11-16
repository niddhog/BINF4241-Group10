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
}
