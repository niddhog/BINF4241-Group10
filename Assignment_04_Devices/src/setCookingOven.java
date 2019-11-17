public class setCookingOven implements Command{

    Oven oven;
    boolean cooking;

    public setCookingOven(Oven oven, boolean cooking){
        this.oven=oven;
        this.cooking =cooking;
    }

    @Override
    public void execute() {
        oven.setCooking(cooking);
    }
}
