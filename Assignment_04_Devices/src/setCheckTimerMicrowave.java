public class setCheckTimerMicrowave implements Command{
    Microwave microwave;
    int checkTimer;

    public setCheckTimerMicrowave(Microwave microwave, int checkTimer){
        this.microwave=microwave;
        this.checkTimer=checkTimer;
    }

    @Override
    public void execute() {
        microwave.setCheckTimer(checkTimer);
    }
}
