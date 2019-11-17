public class SetTimerOven implements Command {

    Oven theDevice;
    private int timer;

    public SetTimerOven(Oven newDevice, int timerVal){

        theDevice = newDevice;  //this is a command Object
        this.timer = timerVal;

    }

    @Override
    public void execute() {

        theDevice.setTimer(timer,false);

    }

    @Override
    public void undo() {

        theDevice.setTimer(-1,true);

    }
}
