package Devices;

import Interfaces.TimerInterface;

public class CleaningRobot extends MasterDevice implements TimerInterface{

    public CleaningRobot(String name){
        super.setName(name);
    }

    @Override
    public int checkTimer() {
        return 0;
    }

    @Override
    public void upTimer() {
    }

    @Override
    public void resetTimer() {

    }
}
