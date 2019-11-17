package Devices;

import Interfaces.OnOffInterface;

public class MicroWave extends MasterDevice implements OnOffInterface {

    public MicroWave(String name){
        super.setName(name);
    }

    @Override
    public void switchOn() {
    }

    @Override
    public void switchOff() {
    }
}
