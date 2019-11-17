public class isOnMicrowave implements Command{
    Microwave microwave;

    public isOnMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.isOn();
    }
}
