public class switchOffMicrowave implements Command{
    Microwave microwave;

    public switchOffMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.switchOff();
    }
}

