public class Dishwasher {
    private boolean on;
    private int timer;
    private String[] program;
    private boolean cleaning;
    private int checkTimer;
    private boolean stopped;

    public Dishwasher(){

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

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
