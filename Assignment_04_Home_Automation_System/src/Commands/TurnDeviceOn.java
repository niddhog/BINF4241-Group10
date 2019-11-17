package Commands;

import Interfaces.Command;
import Interfaces.OnOffInterface;

public class TurnDeviceOn implements Command {

    OnOffInterface device;

    public TurnDeviceOn(OnOffInterface newDevice){
        device = newDevice;
    }

    @Override
    public void execute() {
        device.switchOn();
    }
}
