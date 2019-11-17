package Commands;

import Interfaces.Command;
import Devices.CleaningRobot;

public class SetTimerRobo implements Command {

    CleaningRobot theDevice;
    private int timer;

    public SetTimerRobo(CleaningRobot newDevice, int timerVal){

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
