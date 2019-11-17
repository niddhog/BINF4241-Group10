package Interfaces;

//Interface for the following receivers: Cleaning Robot
public interface RoboticDevices {
    public void checkBatteryStatus();
    public void checkBatteryCharging();
    public void checkCompletion();
    public void continueWork();
}
