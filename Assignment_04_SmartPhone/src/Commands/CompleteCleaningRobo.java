package Commands;
import Interfaces.Command;
import Devices.CleaningRobot;

public class CompleteCleaningRobo implements Command {

    CleaningRobot theDevice;

    public CompleteCleaningRobo(CleaningRobot newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.continueWork();

    }

    @Override
    public void undo() {
        theDevice.interrupt();
    }
}
