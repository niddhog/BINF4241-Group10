package Commands;

import Interfaces.Command;
import Devices.CleaningRobot;

public class StartRobo implements Command {

    CleaningRobot theDevice;

    public StartRobo(CleaningRobot newDevice){

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
