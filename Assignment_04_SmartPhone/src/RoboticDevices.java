//Interface for the following receivers: Cleaning Robot
public interface RoboticDevices {
    public void setTimer();
    public void start();
    public void checkBatteryStatus();
    public void checkBatteryCharging();
    public void interrupt();
}
