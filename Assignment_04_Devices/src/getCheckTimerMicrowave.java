public class getCheckTimerMicrowave implements Command{
    Microwave microwave;

    public getCheckTimerMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.getCheckTimer();
    }
}

