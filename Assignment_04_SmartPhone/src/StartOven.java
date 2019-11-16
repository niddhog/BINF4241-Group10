public class StartOven implements Command {

    Oven theDevice;

    public StartOven(Oven newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.start();

    }

    @Override
    public void undo() {
        theDevice.interrupt();
    }
}
