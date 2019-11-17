public class setInterruptedMicrowave implements Command{
    Microwave microwave;
    boolean interrupted;

    public setInterruptedMicrowave(Microwave microwave, boolean interrupted){
        this.microwave=microwave;
        this.interrupted=interrupted;
    }

    @Override
    public void execute() {
        microwave.setInterrupted(interrupted);
    }
}
