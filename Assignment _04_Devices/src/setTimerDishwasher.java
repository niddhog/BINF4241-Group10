public class setTimerDishwasher implements Command {
    Dishwasher dishwasher;
    int timer;

    public setTimerDishwasher(Dishwasher dishwasher, int timer){
        this.dishwasher=dishwasher;
        this.timer = timer;
    }

    @Override
    public void execute() {
        dishwasher.setTimer(timer);
    }
}
