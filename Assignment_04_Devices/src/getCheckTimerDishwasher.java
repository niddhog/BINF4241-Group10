public class getCheckTimerDishwasher implements Command {
    Dishwasher dishwasher;
    int timer;

    public getCheckTimerDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.getCheckTimer();
    }
}