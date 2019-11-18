package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class SwitchOnMicrowave implements Command {

    MicroWave theDevice;

    public SwitchOnMicrowave(MicroWave newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.switchOn();

    }

    @Override
    public void undo() {

        theDevice.switchOff();

    }
}
