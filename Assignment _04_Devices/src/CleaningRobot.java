public class CleaningRobot {
    private int timer;
    private int base;
    private int battery;
    private int cleaningPercentage;

    public CleaningRobot(){}

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getCleaningPercentage() {
        return cleaningPercentage;
    }

    public void setCleaningPercentage(int cleaningPercentage) {
        this.cleaningPercentage = cleaningPercentage;
    }
}
