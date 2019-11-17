public class getProgramDishwasher implements Command {
    Dishwasher dishwasher;

    public getProgramDishwasher(Dishwasher dishwasher){
        this.dishwasher=dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.getProgram();
    }
}
