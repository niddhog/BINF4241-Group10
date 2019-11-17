public class isBakingMicrowave implements Command{
    Microwave microwave;

    public isBakingMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    @Override
    public void execute() {
        microwave.isBaking();
    }
}
