public class setBakingMicrowave implements Command{
    Microwave microwave;
    boolean baking;

    public setBakingMicrowave(Microwave microwave, boolean baking){
        this.microwave=microwave;
        this.baking=baking;
    }

    @Override
    public void execute() {
        microwave.setBaking(baking);
    }
}

