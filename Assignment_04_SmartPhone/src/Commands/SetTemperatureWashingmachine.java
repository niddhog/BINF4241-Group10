package Commands;

import Interfaces.Command;
import Devices.WashingMachine;

public class SetTemperatureWashingmachine implements Command {

    WashingMachine theDevice;
    private int temperature;

    public SetTemperatureWashingmachine(WashingMachine newDevice, int temperatureVal){

        theDevice = newDevice;  //this is a command Object
        this.temperature = temperatureVal;

    }

    @Override
    public void execute() {

        theDevice.selectDegree(temperature, false);

    }

    @Override
    public void undo() {
        theDevice.selectDegree(-1, true);
    }
}
