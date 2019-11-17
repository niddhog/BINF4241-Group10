public class SelectProgramOven implements Command {
    Oven theDevice;
    private int programNr;

    public SelectProgramOven(Oven newDevice, int value){

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
