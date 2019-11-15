//This is the receiver Oven

public class Oven implements CookingDevices {

    private int timer = 0;  //Variable holds the timer value in seconds
    private int temperature = 0;  //Temperature in degree celsius

    @Override
    public void switchOn() {
        System.out.println("Oven is ON");
    }

    @Override
    public void switchOff() {
        System.out.println("Oven is OFF");
    }

    @Override
    public void setTimer(int value) {

    }

    @Override
    public void setTemperature(int value) {

    }

    @Override
    public void start() {

    }

    @Override
    public void checkTimer() {

    }

    @Override
    public void interrupt() {

    }

}
