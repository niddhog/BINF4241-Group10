package Commands;

import Interfaces.Command;
import Devices.Dishwasher;

public class StartDishwasher implements Command {

    Dishwasher theDevice;

    public StartDishwasher(Dishwasher newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.start();

    }

    @Override
    public void undo() {
        theDevice.interrupt();
    }
}
