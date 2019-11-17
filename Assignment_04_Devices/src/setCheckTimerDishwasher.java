public class setCheckTimerDishwasher implements Command {
    Dishwasher dishwasher;
    int checkTimer;

    public setCheckTimerDishwasher(Dishwasher dishwasher, int chekcTimer){
        this.dishwasher=dishwasher;
        this.checkTimer = chekcTimer;
    }

    @Override
    public void execute() {
        dishwasher.setCheckTimer(checkTimer);
    }
}
