//Interface for the following receivers: Oven & Microwave

public interface CookingDevices {
    public void setTimer(int value);
    public void setTemperature(int value);
    public void start();
    public void checkTimer();
    public void interrupt();
    public void switchOn();
    public void switchOff();
}
