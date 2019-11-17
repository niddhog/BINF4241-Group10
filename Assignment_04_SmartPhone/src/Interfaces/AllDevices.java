package Interfaces;

public interface AllDevices {

    public int getDeviceNr();
    public boolean getIsOn();
    public void displayFunctionMenu();
    public void start();
    public void interrupt();
    public void setTimer(int value, boolean undo);
    public void checkTimer();
    public long calculateTime();
}
