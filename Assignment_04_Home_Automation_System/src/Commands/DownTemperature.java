package Commands;

import Interfaces.Command;
import Interfaces.TemperatureInterface;

public class DownTemperature implements Command {
    TemperatureInterface device;

    public DownTemperature(TemperatureInterface newDevice){
        device = newDevice;
    }

    @Override
    public void execute() {
        device.downTemperature();
    }
}