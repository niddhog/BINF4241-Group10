package Commands;

import Interfaces.InterruptInterface;

public class Interupt implements Command{

    InterruptInterface device;

    public Interupt(InterruptInterface newDevice){
        this.device = newDevice;

    }
    @Override
    public void execute() {
        this.device.interrupt();
    }
}
