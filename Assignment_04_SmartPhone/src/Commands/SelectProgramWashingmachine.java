package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class SelectProgramWashingmachine implements Command {
    WashingMachine theDevice;
    private int programNr;

    public SelectProgramWashingmachine(WashingMachine newDevice, int value){

        theDevice = newDevice;  //this is a command Object
        this.programNr = value;

    }

    @Override
    public void execute() {

        theDevice.selectProgram(programNr, false);

    }

    @Override
    public void undo() {
        theDevice.selectProgram(-1, true);
    }
}
