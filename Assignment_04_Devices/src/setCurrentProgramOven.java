public class setCurrentProgramOven implements Command {

    Oven oven;
    String program;

    public setCurrentProgramOven(Oven oven, String program){
        this.oven=oven;
        this.program=program;
    }

    @Override
    public void execute() {
        oven.setCurrentProgram(program);
    }
}
