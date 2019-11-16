public class SetTemperatureOven implements Command {

    Oven theDevice;
    private int temperature;

    public SetTemperatureOven(Oven newDevice, int temperatureVal){

        theDevice = newDevice;  //this is a command Object
        this.temperature = temperatureVal;

    }

    @Override
    public void execute() {

        theDevice.setTemperature(temperature);

    }

    @Override
    public void undo() {

        theDevice.setTemperature(0);

    }
}
