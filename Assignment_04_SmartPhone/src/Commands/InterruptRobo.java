//This function does not switch the Robo off, as the Robo can't be switched off
package Commands;

import Interfaces.Command;
import Devices.CleaningRobot;

public class InterruptRobo implements Command {

    CleaningRobot theDevice;

    public InterruptRobo(CleaningRobot newDevice){

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
