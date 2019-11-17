public class setTimerMicrowave implements Command{
    Microwave microwave;
    int timer;

    public setTimerMicrowave(Microwave microwave, int timer){
        this.microwave=microwave;
        this.timer=timer;
    }

    @Override
    public void execute() {
        microwave.setTimer(timer);
    }
}

