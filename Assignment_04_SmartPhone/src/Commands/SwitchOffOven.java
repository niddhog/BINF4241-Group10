package Commands;

import Interfaces.Command;
import Devices.Oven;

public class SwitchOffOven implements Command {

    Oven theDevice;

    public SwitchOffOven(Oven newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOff();

    }

    @Override
    public void undo() {

        theDevice.switchOn();

    }
}
