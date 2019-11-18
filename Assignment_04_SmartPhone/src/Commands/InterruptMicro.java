package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class InterruptMicro implements Command {

    MicroWave theDevice;

    public InterruptMicro(MicroWave newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.interrupt();

    }

    @Override
    public void undo() {

        theDevice.start();

    }
}
