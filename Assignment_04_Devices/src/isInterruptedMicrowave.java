public class isInterruptedMicrowave implements Command{
    Microwave microwave;

    public isInterruptedMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.isInterrupted();
    }
}

