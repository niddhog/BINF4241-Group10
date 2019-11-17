public class getCheckTimerOven implements Command {

    Oven oven;

    public getCheckTimerOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.getCheckTimer();
    }
}
