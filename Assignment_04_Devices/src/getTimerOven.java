public class getTimerOven implements Command{
    Oven oven;

    public getTimerOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.getTimer();
    }
}
