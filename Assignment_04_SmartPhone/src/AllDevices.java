public interface AllDevices {

    public int getDeviceNr();
    public boolean getIsOn();
    public void displayFunctionMenu();
    public void start();
    public void interrupt();
    public void setTimer(int value);
    public void checkTimer();
}
