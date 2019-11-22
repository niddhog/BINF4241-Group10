package Commands;
import Interfaces.Command;
import Devices.CleaningRobot;

public class CheckBatteryStatusRobo implements Command {

    CleaningRobot theDevice;

    public CheckBatteryStatusRobo(CleaningRobot newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkBatteryStatus();

    }

    @Override
    public void undo() {
        //this just gets removed from the commandList,nothing gets returned
    }
}
