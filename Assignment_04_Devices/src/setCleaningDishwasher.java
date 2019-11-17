public class setCleaningDishwasher implements Command {
    Dishwasher dishwasher;
    boolean cleaning;

    public setCleaningDishwasher(Dishwasher dishwasher, boolean cleaning){
        this.dishwasher=dishwasher;
        this.cleaning = cleaning;
    }

    @Override
    public void execute() {
        dishwasher.setCleaning(cleaning);
    }
}

