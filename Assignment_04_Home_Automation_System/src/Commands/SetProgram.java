package Commands;

import Enumerations.OvenPrograms;
import Interfaces.Command;
import Interfaces.ProgramInterface;

public class SetProgram implements Command {

    private ProgramInterface device;
    private OvenPrograms prog;

    public SetProgram(ProgramInterface newDevice, OvenPrograms prog){
        this.device = newDevice;
        this.prog = prog;
    }

    @Override
    public void execute() {
        device.setProgram(prog);
    }
}
