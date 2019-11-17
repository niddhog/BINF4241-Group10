public class switchOffDishwasher implements Command{
    Dishwasher dishwasher;

    public switchOffDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.switchOff();
    }
}
