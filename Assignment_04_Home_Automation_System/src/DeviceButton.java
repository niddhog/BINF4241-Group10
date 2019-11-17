//invoker, beschwörer

import Commands.Command;

public class DeviceButton {

    Command theCommand;
    DeviceButton(Command newCommand){
        theCommand = newCommand;
    }

    public void press(){
        theCommand.execute();
    }
}
