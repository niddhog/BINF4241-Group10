public class SwitchOffOven implements Command {

    CookingDevices theDevice;

    public SwitchOffOven(CookingDevices newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOff();

    }
}
