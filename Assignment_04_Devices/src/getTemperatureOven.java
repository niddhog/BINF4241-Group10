public class getTemperatureOven implements Command{
    Oven oven;


    public getTemperatureOven(Oven oven){
        this.oven=oven;
    }

    @Override
    public void execute() {
        oven.getTemperature();
    }
}
