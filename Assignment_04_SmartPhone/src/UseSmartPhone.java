//This is the main Application #IDEA: SINGLETON for each Device (there shouldn't be 2 Ovens)
import Commands.*;
import Devices.*;
import Util.DeviceButtons;
import Util.SmartPhone;

import java.util.Scanner;

public class UseSmartPhone {
    private static Oven oven = SmartPhone.getOven();
    private static MicroWave microWave = SmartPhone.getMicroWave();
    private static Dishwasher dishWasher = SmartPhone.getDishwasher();
    private static WashingMachine washingMachine = SmartPhone.getWashingMaschine();
    private static CleaningRobot cleaningRobot = SmartPhone.getCleaningRobot();
    private static DeviceButtons deviceButtons = new DeviceButtons();
    //Todo Make Singletons out of these 5 Classes

    public static void main(String[] args) {
        //List<Interfaces.AllDevices> deviceList = Util.SmartPhone.getDevices();
        displayTitle();

        while(true){  //Starts the main Loop
            displayMainMenu();
            int userInput = createUserInput(1);
            while(true){
                if(oven.getDeviceNr()==userInput){
                    oven.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){  //SWITCH ON
                        if(!oven.getIsOn()){
                            SwitchOnOven onCommand = new SwitchOnOven(oven);
                            deviceButtons.addButtonCommand(onCommand);
                            deviceButtons.press();
                        }
                        else{  //SWITCH OFF
                            //todo implement Off Switch
                        }
                    }
                    else if(userInputDepth2==1){  //BACK
                        if(!oven.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{  //SET TIMER
                            int userInputDepth3 = createUserInput(3);
                            SetTimerOven setTimeCommand = new SetTimerOven(oven,userInputDepth3);
                            deviceButtons.addButtonCommand(setTimeCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==2){  //SET TEMPERATURE
                        int userInputDepth3 = createUserInput(4);
                        SetTemperatureOven setTimeCommand = new SetTemperatureOven(oven,userInputDepth3);
                        deviceButtons.addButtonCommand(setTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //SELECT PROGRAM
                        oven.displayPrograms();
                        int userInputDepth4 = createUserInput(5);
                        SelectProgramOven onCommand = new SelectProgramOven(oven,userInputDepth4);
                        deviceButtons.addButtonCommand(onCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //START COOKING
                        StartOven onCommand = new StartOven(oven);
                        deviceButtons.addButtonCommand(onCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //CHECK TIMER
                        CheckTimerOven setTimeCommand = new CheckTimerOven(oven);
                        deviceButtons.addButtonCommand(setTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==6){  //INTERRUPT
                        InterruptOven setTimeCommand = new InterruptOven(oven);
                        deviceButtons.addButtonCommand(setTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==7){  //BACK
                        break;
                    }
                    else if(userInputDepth2==-1){  //UNDO
                        deviceButtons.pressUndo();
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(microWave.getDeviceNr()==userInput){
                    microWave.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!microWave.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{

                        }
                    }
                    else if(userInputDepth2==2){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==3){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==4){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==5){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==6){
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(dishWasher.getDeviceNr()==userInput){
                    dishWasher.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!dishWasher.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{

                        }
                    }
                    else if(userInputDepth2==2){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==3){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==4){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==5){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==6){
                        break;
                    }

                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(washingMachine.getDeviceNr()==userInput){
                    washingMachine.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!washingMachine.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{

                        }
                    }
                    else if(userInputDepth2==2){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==3){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==4){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==5){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==6){
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(cleaningRobot.getDeviceNr()==userInput){
                    cleaningRobot.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!cleaningRobot.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{

                        }
                    }
                    else if(userInputDepth2==2){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==3){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==4){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==5){
                        System.out.println("implement more");
                    }
                    else if(userInputDepth2==6){
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(userInput==-1){
                    //Todo -1 triggers the Undo function
                    break;
                }
                else{
                    System.out.println("This Device does not exists, please select again");
                    break;
                }

            }

        }





        /*
        CookingDevices newDevice = Util.SmartPhone.getDevice();  //returns all Devices linked to the Util.SmartPhone

        Commands.SwitchOnOven onCommand = new Commands.SwitchOnOven(newDevice);
        DeviceButton turnOnPressed = new DeviceButton(onCommand);
        turnOnPressed.press();

        Commands.SwitchOffOven offCommand = new Commands.SwitchOffOven(newDevice);
        DeviceButton turnOffPressed = new DeviceButton(offCommand);
        turnOffPressed.press();

        //-------------------------------------------------------

        Devices.Oven oven = new Devices.Oven();
        Devices.MicroWave microWave = new Devices.MicroWave();

        List<CookingDevices> cookingDevices = new ArrayList<CookingDevices>();  //create List with all Cooking Dev.
        cookingDevices.add(oven);
        cookingDevices.add(microWave);

        //TurnItAllOff turnOffDevices = new TurnItAllOff(cookingDevices);
        //DeviceButton turnThemOff = new DeviceButton(turnOffDevices;
        //turnThemOff.press();
        */
    }


    private static void displayMainMenu(){
        for(int i = 0; i <= SmartPhone.DEVICE_NR; i++){
            System.out.println("+---------------------------+");
            if(oven.getDeviceNr()==i){
                System.out.println(oven);
            }
            else if(microWave.getDeviceNr()==i){
                System.out.println(microWave);
            }
            else if(dishWasher.getDeviceNr()==i){
                System.out.println(dishWasher);
            }
            else if(washingMachine.getDeviceNr()==i){
                System.out.println(washingMachine);
            }
            else if(cleaningRobot.getDeviceNr()==i){
                System.out.println(cleaningRobot);
            }
        }
        System.out.println("\n");
    }


    private static void displayTitle(){
        System.out.println("   _____                      _   _    _                      ___   ___   ___   ___  ");
        System.out.println("  / ____|                    | | | |  | |                    |__ \\ / _ \\ / _ \\ / _ \\ ");
        System.out.println(" | (___  _ __ ___   __ _ _ __| |_| |__| | ___  _ __ ___   ___   ) | | | | | | | | | |");
        System.out.println("  \\___ \\| '_ ` _ \\ / _` | '__| __|  __  |/ _ \\| '_ ` _ \\ / _ \\ / /| | | | | | | | | |");
        System.out.println("  ____) | | | | | | (_| | |  | |_| |  | | (_) | | | | | |  __// /_| |_| | |_| | |_| |");
        System.out.println(" |_____/|_| |_| |_|\\__,_|_|   \\__|_|  |_|\\___/|_| |_| |_|\\___|____|\\___/ \\___/ \\___/ ");
        System.out.println("             Hint: Enter -1 whenever you want to undo the last command");
        System.out.print("\n");
    }


    private static int createUserInput(int menuDepth){
        Scanner userInput = new Scanner(System.in);
        String input = null;

        while (true){
            if(menuDepth == 1){
                System.out.println("Select your Device (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 2){
                System.out.println("Select a device functionality (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 3){
                System.out.println("Set the timer (Seconds, enter natural numbers only): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 4){
                System.out.println("Set the Temperature (Degrees Celsius, enter natural numbers only): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 5){
                System.out.println("Select a cooking program (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            if(validateInput(input)){
                return Integer.parseInt(input);
            }
        }
    }


    private static boolean validateInput(String input){  //checks if input is an Integer (returns true) or Not (false)
        try {
            int dummy = Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

}
