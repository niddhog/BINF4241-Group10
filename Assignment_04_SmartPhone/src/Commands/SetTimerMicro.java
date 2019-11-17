package Commands;

import Interfaces.Command;
import Devices.MicroWave;

public class SetTimerMicro implements Command {

    MicroWave theDevice;
    private int timer;

    public SetTimerMicro(MicroWave newDevice, int timerVal){

        theDevice = newDevice;  //this is a command Object
        this.timer = timerVal;

    }

    @Override
    public void execute() {

        theDevice.setTimer(timer,false);

    }

    @Override
    public void undo() {

        theDevice.setTimer(-1,true);

    }
}
