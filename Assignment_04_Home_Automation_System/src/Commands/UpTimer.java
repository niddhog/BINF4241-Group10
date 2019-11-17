package Commands;

import Interfaces.Command;
import Interfaces.TimerInterface;

public class UpTimer implements Command {

    TimerInterface device;

    public UpTimer(TimerInterface newDevice){
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.upTimer();
    }
}
