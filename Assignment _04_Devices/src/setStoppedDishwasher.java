public class setStoppedDishwasher implements Command {
    Dishwasher dishwasher;
    boolean stopped;

    public setStoppedDishwasher(Dishwasher dishwasher, boolean stopped){
        this.dishwasher=dishwasher;
        this.stopped = stopped;
    }

    @Override
    public void execute() {
        dishwasher.setStopped(stopped);
    }
}

