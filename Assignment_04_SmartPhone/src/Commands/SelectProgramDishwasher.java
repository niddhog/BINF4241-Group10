package Commands;

import Interfaces.Command;
import Devices.Dishwasher;

public class SelectProgramDishwasher implements Command {
    Dishwasher theDevice;
    private int programNr;

    public SelectProgramDishwasher(Dishwasher newDevice, int value){

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
