public class getProgramOven implements Command{
    Oven oven;

    public getProgramOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.getProgram();
    }
}
