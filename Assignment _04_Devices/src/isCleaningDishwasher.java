public class isCleaningDishwasher implements Command {
    Dishwasher dishwasher;

    public isCleaningDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.isCleaning();
    }
}
