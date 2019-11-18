package Commands;

import Interfaces.Command;
import Devices.Dishwasher;

public class InterruptDishwasher implements Command {

    Dishwasher theDevice;

    public InterruptDishwasher(Dishwasher newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.interrupt();

    }

    @Override
    public void undo() {

        theDevice.start();

    }
}
