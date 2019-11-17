public class WashingMachine {
    private boolean on;
    private int degrees;
    private int timer;
    private String[] program;
    private boolean cleaning;
    private int checkTimer; // only reset the state, if the program is finished(time 00:00)

    public WashingMachine(){

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

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String[] getProgram() {
        return program;
    }

    public int getCheckTimer() {
        return checkTimer;
    }

    public void setCheckTimer(int checkTimer) {
        this.checkTimer = checkTimer;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }

}
