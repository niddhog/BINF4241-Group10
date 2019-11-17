public class setCheckTimerOven implements Command {
    Oven oven;
    int checkTimer;

    public setCheckTimerOven(Oven oven, int checkTimer){
        this.oven=oven;
        this.checkTimer=checkTimer;
    }

    @Override
    public void execute() {
        oven.setCheckTimer(checkTimer);
    }
}
