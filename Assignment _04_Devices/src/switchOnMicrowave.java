public class switchOnMicrowave implements Command{
    Microwave microwave;

    public switchOnMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.switchOn();
    }
}

