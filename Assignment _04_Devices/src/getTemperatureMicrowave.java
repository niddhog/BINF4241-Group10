public class getTemperatureMicrowave implements Command{
    Microwave microwave;

    public getTemperatureMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.getTemperature();
    }
}

