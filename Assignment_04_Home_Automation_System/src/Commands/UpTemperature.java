package Commands;

import Interfaces.Command;
import Interfaces.TemperatureInterface;

public class UpTemperature implements Command {

    TemperatureInterface device;

    public UpTemperature(TemperatureInterface newDevice){
        device = newDevice;
    }

    @Override
    public void execute() {
        device.upTemperature();
    }
}
