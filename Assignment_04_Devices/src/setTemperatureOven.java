public class setTemperatureOven implements Command {
    Oven oven;
    int temperature;

    public setTemperatureOven(Oven oven, int temperature){
        this.oven=oven;
        this.temperature=temperature;
    }

    @Override
    public void execute() {
        oven.setTemperature(temperature);
    }
}
