public class SwitchOnOven implements Command {

    CookingDevices theDevice;

    public SwitchOnOven(CookingDevices newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOn();

    }
}
