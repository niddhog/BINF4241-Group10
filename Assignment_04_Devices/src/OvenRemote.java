public class OvenRemote {
    Command command;

    public  OvenRemote(){}

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
