public class Microwave {
    private boolean on;
    private int timer;
    private int temperature;
    private boolean baking;
    private int checkTimer;
    private boolean interrupted;

    public Microwave(){

    }

    public boolean isOn() {
        return on;
    }

    public void switchOn(){
        on = true;
    }

    public void switchOff(){
        on = false;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    public int getCheckTimer() {
        return checkTimer;
    }

    public void setCheckTimer(int checkTimer) {
        this.checkTimer = checkTimer;
    }

    public boolean isBaking() {
        return baking;
    }

    public void setBaking(boolean baking) {
        this.baking = baking;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }
}
