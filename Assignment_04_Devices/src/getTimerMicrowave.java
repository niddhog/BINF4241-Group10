public class getTimerMicrowave  implements Command{
    Microwave microwave;

    public getTimerMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.getTimer();
    }
}

