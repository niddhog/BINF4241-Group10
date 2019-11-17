package Devices;

import Interfaces.OnOffInterface;

public class DishWasher extends MasterDevice implements OnOffInterface {

    public DishWasher(String name){
        super.setName(name);
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }
}
