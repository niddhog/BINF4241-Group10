package Interfaces;

//Interface for the following receivers: Devices.Dishwasher & Washing Machine
public interface ProgrammableDevices {
    public void selectProgram(int value, boolean undo);
    public void displayPrograms();

}
