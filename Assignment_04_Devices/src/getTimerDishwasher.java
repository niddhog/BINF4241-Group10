public class getTimerDishwasher implements Command {
    Dishwasher dishwasher;

    public getTimerDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.getTimer();
    }
}
