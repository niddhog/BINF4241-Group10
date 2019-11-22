package Commands;
import Interfaces.Command;
import Devices.Oven;

public class CheckTimerOven implements Command {

    Oven theDevice;

    public CheckTimerOven(Oven newDevice){

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
