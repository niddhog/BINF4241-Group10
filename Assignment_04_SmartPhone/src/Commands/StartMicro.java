package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class StartMicro implements Command {

    MicroWave theDevice;

    public StartMicro(MicroWave newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.start();

    }

    @Override
    public void undo() {
        theDevice.interrupt();
    }
}
