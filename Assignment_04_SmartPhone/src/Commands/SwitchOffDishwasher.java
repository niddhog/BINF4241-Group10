package Commands;

import Interfaces.Command;
import Devices.Dishwasher;

public class SwitchOffDishwasher implements Command {

    Dishwasher theDevice;

    public SwitchOffDishwasher(Dishwasher newDevice){

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
