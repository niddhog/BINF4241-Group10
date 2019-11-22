package Commands;
import Interfaces.Command;
import Devices.Dishwasher;

public class CheckTimerDishwasher implements Command {

    Dishwasher theDevice;

    public CheckTimerDishwasher(Dishwasher newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkTimer();

    }

    @Override
    public void undo() {
        //this just gets removed from the commandList,nothing gets returned
    }
}
