public class setTimerOven implements Command{
    Oven oven;
    int timer;

    public setTimerOven(Oven oven, int timer){
        this.oven=oven;
        this.timer=timer;
    }

    @Override
    public void execute() {
        oven.setTimer(timer);
    }
}
