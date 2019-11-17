package Devices;

import Interfaces.OnOffInterface;

public class WashingMaschine extends MasterDevice implements OnOffInterface {

    public WashingMaschine(String name){
        super.setName(name);
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }
}
