public class SetTimerOven implements Command {

    CookingDevices theDevice;
    private int timer;

    public SetTimerOven(CookingDevices newDevice, int timerVal){

        theDevice = newDevice;  //this is a command Object
        this.timer = timerVal;

    }

    @Override
    public void execute() {

        theDevice.setTimer(timer);

    }
}
