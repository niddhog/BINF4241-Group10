public class CheckTimerOven implements Command {

    CookingDevices theDevice;

    public CheckTimerOven(CookingDevices newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkTimer();

    }
}
