public class InterruptOven implements Command {

    Oven theDevice;

    public InterruptOven(Oven newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.interrupt();

    }

    @Override
    public void undo() {

        theDevice.start();

    }
}
