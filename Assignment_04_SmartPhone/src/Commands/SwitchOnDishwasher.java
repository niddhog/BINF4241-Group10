package Commands;

import Interfaces.Command;
import Devices.Dishwasher;

public class SwitchOnDishwasher implements Command {

    Dishwasher theDevice;

    public SwitchOnDishwasher(Dishwasher newDevice){

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
