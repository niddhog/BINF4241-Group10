//invoker, beschwörer

import Interfaces.Command;

public class DeviceButton {

    Command theCommand;
    DeviceButton(Command newCommand){
        theCommand = newCommand;
    }

    public void press(){
        theCommand.execute();
    }
}
