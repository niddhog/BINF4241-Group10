package Devices;

public class MasterDevice {

    private String deviceName;

    //move few things that all devices have to master...
    public String getName(){
        return deviceName;
    }

    public void setName(String name) {
        this.deviceName = name;
    }
}
