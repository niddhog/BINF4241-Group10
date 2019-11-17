package Commands;

import Interfaces.TimerInterface;

public class ResetTimer implements Command {

    TimerInterface device;

    public ResetTimer(TimerInterface newDevice){
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.resetTimer();
    }
}
