package Commands;
import Interfaces.Command;
import Devices.MicroWave;

public class CheckTimerMicro implements Command {

    MicroWave theDevice;

    public CheckTimerMicro(MicroWave newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkTimer();

    }

    @Override
    public void undo() {
        //this just gets removed from the commandList,nothing gets returned
    }
}
