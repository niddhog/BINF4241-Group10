public class setInterruptedOven implements Command{
    Oven oven;
    boolean interrupted;

    public setInterruptedOven(Oven oven, boolean interrupted){
        this.oven=oven;
        this.interrupted=interrupted;
    }

    @Override
    public void execute() {
        oven.setInterrupted(interrupted);
    }
}
