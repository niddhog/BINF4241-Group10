public class isStoppedDishwasher implements Command {
    Dishwasher dishwasher;

    public isStoppedDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.isStopped();
    }
}

