package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class SwitchOnWashingmachine implements Command {

    WashingMachine theDevice;

    public SwitchOnWashingmachine(WashingMachine newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOn();

    }

    @Override
    public void undo() {

        theDevice.switchOff();

    }
}
