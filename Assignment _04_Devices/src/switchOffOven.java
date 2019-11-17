public class switchOffOven implements Command{
    Oven oven;

    public switchOffOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.switchOff();
    }
}
