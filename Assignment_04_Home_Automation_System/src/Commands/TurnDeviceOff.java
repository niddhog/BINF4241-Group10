package Commands;

import Interfaces.OnOffInterface;

public class TurnDeviceOff implements Command {

    OnOffInterface device;

    public TurnDeviceOff(OnOffInterface newDevice){
        device = newDevice;
    }

    @Override
    public void execute() {
        device.switchOff();
    }
}

