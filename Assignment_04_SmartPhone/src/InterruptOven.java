public class InterruptOven implements Command {

    CookingDevices theDevice;

    public InterruptOven(CookingDevices newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.interrupt();

    }
}
