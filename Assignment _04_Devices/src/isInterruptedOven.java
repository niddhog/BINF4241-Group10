public class isInterruptedOven implements Command {
    Oven oven;

    public isInterruptedOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.isInterrupted();
    }
}
