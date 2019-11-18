package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class StartWashingmachine implements Command {

    WashingMachine theDevice;

    public StartWashingmachine(WashingMachine newDevice){

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
