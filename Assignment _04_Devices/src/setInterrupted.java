public class setInterrupted implements Command{
    Oven oven;
    boolean interrupted;

    public setInterrupted(Oven oven, boolean interrupted){
        this.oven=oven;
        this.interrupted=interrupted;
    }

    @Override
    public void execute() {
        oven.setInterrupted(interrupted);
    }
}
