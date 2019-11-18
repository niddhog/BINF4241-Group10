package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class SwitchOffMicro implements Command {

    MicroWave theDevice;

    public SwitchOffMicro(MicroWave newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOff();

    }

    @Override
    public void undo() {

        theDevice.switchOn();

    }
}
