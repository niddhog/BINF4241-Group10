public class switchOnOven implements Command {
    Oven oven;

    public switchOnOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.switchOn();
    }
}
