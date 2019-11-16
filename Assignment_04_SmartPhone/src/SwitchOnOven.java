public class SwitchOnOven implements Command {

    Oven theDevice;

    public SwitchOnOven(Oven newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOn();

    }

    @Override
    public void undo() {

        theDevice.switchOff();

    }
}
