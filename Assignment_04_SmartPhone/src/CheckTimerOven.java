public class CheckTimerOven implements Command {

    Oven theDevice;

    public CheckTimerOven(Oven newDevice){

        theDevice = newDevice;  //this is a command Object

    }

    @Override
    public void execute() {

        theDevice.checkTimer();

    }

    @Override
    public void undo() {

        //Was soll ich hier undoen?

    }
}
