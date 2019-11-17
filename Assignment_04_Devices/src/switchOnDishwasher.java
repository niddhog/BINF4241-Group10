public class switchOnDishwasher implements Command {
    Dishwasher dishwasher;

    public switchOnDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.switchOn();
    }
}
