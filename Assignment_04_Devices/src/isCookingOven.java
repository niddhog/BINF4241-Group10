public class isCookingOven implements Command {

    Oven oven;

    public isCookingOven(Oven oven){
        this.oven=oven;
     }

    @Override
    public void execute() {
        oven.isCooking();
    }
}
