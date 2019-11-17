package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class SetTemperatureMicro implements Command {

    MicroWave theDevice;
    private int temperature;

    public SetTemperatureMicro(MicroWave newDevice, int temperatureVal){

        theDevice = newDevice;  //this is a command Object
        this.temperature = temperatureVal;

    }

    @Override
    public void execute() {

        theDevice.setTemperature(temperature, false);

    }

    @Override
    public void undo() {
        theDevice.setTemperature(-1, true);
    }
}
