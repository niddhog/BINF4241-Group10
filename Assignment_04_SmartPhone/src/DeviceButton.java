//This is the Invoker (Does not know what device or command is being used)

public class DeviceButton {

    Command specificCommand;

    public DeviceButton(Command newCommand){

        this.specificCommand = newCommand;

    }

    public void press(){

        specificCommand.execute();

    }

    public void pressUndo(){

        specificCommand.undo();

    }

}
