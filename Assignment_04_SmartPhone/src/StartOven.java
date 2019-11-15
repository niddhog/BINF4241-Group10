public class StartOven implements Command {

    CookingDevices theDevice;

    public StartOven(CookingDevices newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.start();

    }
}
