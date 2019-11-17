public class isOnOven implements Command{

    Oven oven;

    public isOnOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.isOn();
    }
}
