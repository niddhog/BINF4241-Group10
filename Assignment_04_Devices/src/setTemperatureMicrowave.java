public class setTemperatureMicrowave implements Command{
    Microwave microwave;
    int temperature;

    public setTemperatureMicrowave(Microwave microwave, int temperature){
        this.microwave=microwave;
        this.temperature=temperature;
    }

    @Override
    public void execute() {
        microwave.setTemperature(temperature);
    }
}
