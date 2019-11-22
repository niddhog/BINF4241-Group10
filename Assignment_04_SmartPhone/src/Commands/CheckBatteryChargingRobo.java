package Commands;
import Interfaces.Command;
import Devices.CleaningRobot;

public class CheckBatteryChargingRobo implements Command {

    CleaningRobot theDevice;

    public CheckBatteryChargingRobo(CleaningRobot newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkBatteryCharging();

    }

    @Override
    public void undo() {
        //this just gets removed from the commandList,nothing gets returned
    }
}
