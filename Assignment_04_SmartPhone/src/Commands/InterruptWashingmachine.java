package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class InterruptWashingmachine implements Command {

    WashingMachine theDevice;

    public InterruptWashingmachine(WashingMachine newDevice){

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
