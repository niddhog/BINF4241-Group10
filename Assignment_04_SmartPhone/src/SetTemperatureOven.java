public class SetTemperatureOven implements Command {

    CookingDevices theDevice;
    private int temperature;

    public SetTemperatureOven(CookingDevices newDevice, int temperatureVal){

        theDevice = newDevice;  //this is a command Object
        this.temperature = temperatureVal;

    }

    @Override
    public void execute() {

        theDevice.setTemperature(temperature);

    }
}
