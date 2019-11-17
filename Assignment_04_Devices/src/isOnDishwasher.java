public class isOnDishwasher implements Command {
    Dishwasher dishwasher;

    public isOnDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.isOn();
    }
}
