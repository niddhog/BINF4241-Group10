//returns the kind of device we're using
import java.util.ArrayList;
import java.util.List;

public class SmartPhone {
    public static int DEVICE_NR = 0;

    //All possible Devices the SmartPhone can control must be implemented in here
    public static List<AllDevices> getDevices(){
        List<AllDevices> deviceList = new ArrayList<>();  //create List with all Cooking Dev.
        Oven oven = new Oven();
        MicroWave microWave = new MicroWave();
        Dishwasher dishwasher = new Dishwasher();
        WashingMachine washingMachine = new WashingMachine();
        CleaningRobot cleaningRobot = new CleaningRobot();

        deviceList.add(oven);
        deviceList.add(microWave);
        deviceList.add(dishwasher);
        deviceList.add(washingMachine);
        deviceList.add(cleaningRobot);

        return deviceList;
    }

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
