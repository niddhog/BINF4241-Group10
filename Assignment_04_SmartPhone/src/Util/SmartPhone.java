package Util;//returns the kind of device we're using
import Devices.*;

public class SmartPhone {
    public static int DEVICE_NR = 0;

    //All possible Devices the Util.SmartPhone can control must be implemented in here
    /*public static List<Interfaces.AllDevices> getDevices(){
        List<Interfaces.AllDevices> deviceList = new ArrayList<>();  //create List with all Cooking Dev.
        Devices.Oven oven = new Devices.Oven();
        Devices.MicroWave microWave = new Devices.MicroWave();
        Devices.Dishwasher dishwasher = new Devices.Dishwasher();
        Devices.WashingMachine washingMachine = new Devices.WashingMachine();
        Devices.CleaningRobot cleaningRobot = new Devices.CleaningRobot();

        deviceList.add(oven);
        deviceList.add(microWave);
        deviceList.add(dishwasher);
        deviceList.add(washingMachine);
        deviceList.add(cleaningRobot);

        return deviceList;
    }*/

    public static Oven getOven(){
        return new Oven();
    }

    public static MicroWave getMicroWave(){
        return  new MicroWave();
    }

    public static Dishwasher getDishwasher(){
        return new Dishwasher();
    }

    public static WashingMachine getWashingMaschine(){
        return new WashingMachine();
    }

    public static CleaningRobot getCleaningRobot(){
        return new CleaningRobot();
    }

}
