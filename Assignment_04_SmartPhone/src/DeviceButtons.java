import java.util.ArrayList;
import java.util.List;

//This is the Invoker (Does not know what device or command is being used)

public class DeviceButtons {

    //Command specificCommand;
    List<Command> commandList;


    public DeviceButtons(){

        this.commandList = new ArrayList<>();

    }

    public void press(){

        commandList.get(commandList.size()-1).execute();
    }

    public void pressUndo(){
        if(commandList.size()==0){
            System.out.println("No further Commands can be undone!");
        }
        else{
            System.out.println("The command: " +  commandList.get(commandList.size()-1) + " has been undone!");
            commandList.get(commandList.size()-1).undo();
            commandList.remove(commandList.size()-1);
        }
    }


    public void addButtonCommand(Command newCommand){
        commandList.add(newCommand);
    }

}
