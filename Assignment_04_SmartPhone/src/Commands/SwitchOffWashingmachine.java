package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class SwitchOffWashingmachine implements Command {

    WashingMachine theDevice;

    public SwitchOffWashingmachine(WashingMachine newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOff();

    }

    @Override
    public void undo() {

        theDevice.switchOn();

    }
}
