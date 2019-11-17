package Commands;
import Interfaces.Command;
import Devices.CleaningRobot;

public class CheckCompletionRobo implements Command {

    CleaningRobot theDevice;

    public CheckCompletionRobo(CleaningRobot newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkTimer();

    }

    @Override
    public void undo() {
        //this just gets removed from the commandList,nothing more
    }
}
