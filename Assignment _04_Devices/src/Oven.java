public class Oven {
    private boolean on;
    private int timer;
    private int temperature;
    private String[] program = {"grill", "ventilated", "lower heat only", "upper and lower heat"};
    private String currentProgram;
    private boolean cooking;
    private int checkTimer;
    private boolean interrupted;

    public Oven(){
        on = false;
        timer = 0;
        temperature = 0;
        cooking = false;
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

    public String[] getProgram() {
        return program;
    }

    public String getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(String currentProgram) {
        this.currentProgram = currentProgram;
    }

    public int getCheckTimer() {
        return checkTimer;
    }

    public void setCheckTimer(int checkTimer) {
        this.checkTimer = checkTimer;
    }

    public boolean isCooking() {
        return cooking;
    }

    public void setCooking(boolean cooking) {
        this.cooking = cooking;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }
}
