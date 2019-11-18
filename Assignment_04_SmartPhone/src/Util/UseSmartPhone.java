package Util;//This is the main Application #IDEA: SINGLETON for each Device (there shouldn't be 2 Ovens)
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
                            SwitchOffOven offCommand = new SwitchOffOven(oven);
                            deviceButtons.addButtonCommand(offCommand);
                            deviceButtons.press();
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
                        SetTemperatureOven setTempCommand = new SetTemperatureOven(oven,userInputDepth3);
                        deviceButtons.addButtonCommand(setTempCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //SELECT PROGRAM
                        oven.displayPrograms();
                        int userInputDepth4 = createUserInput(5);
                        SelectProgramOven programCommand = new SelectProgramOven(oven,userInputDepth4);
                        deviceButtons.addButtonCommand(programCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //START COOKING
                        StartOven startCommand = new StartOven(oven);
                        deviceButtons.addButtonCommand(startCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //CHECK TIMER
                        CheckTimerOven checkTimeCommand = new CheckTimerOven(oven);
                        deviceButtons.addButtonCommand(checkTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==6){  //INTERRUPT
                        InterruptOven interruptCommand = new InterruptOven(oven);
                        deviceButtons.addButtonCommand(interruptCommand);
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
                        if(!microWave.getIsOn()){  //SWITCH ON
                            SwitchOnMicrowave onCommand = new SwitchOnMicrowave(microWave);
                            deviceButtons.addButtonCommand(onCommand);
                            deviceButtons.press();
                        }
                        else{  //SWITCH OFF
                            SwitchOffMicro offCommand = new SwitchOffMicro(microWave);
                            deviceButtons.addButtonCommand(offCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==1){  //BACK
                        if(!microWave.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{  //SET TIMER
                            int userInputDepth3 = createUserInput(3);
                            SetTimerMicro setTimeCommand = new SetTimerMicro(microWave,userInputDepth3);
                            deviceButtons.addButtonCommand(setTimeCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==2){  //SET TEMPERATURE
                        int userInputDepth3 = createUserInput(4);
                        SetTemperatureMicro setTempCommand = new SetTemperatureMicro(microWave,userInputDepth3);
                        deviceButtons.addButtonCommand(setTempCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //START BAKING
                        StartMicro startCommand = new StartMicro(microWave);
                        deviceButtons.addButtonCommand(startCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //CHECK TIMER
                        CheckTimerMicro checkTimeCommand = new CheckTimerMicro(microWave);
                        deviceButtons.addButtonCommand(checkTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //INTERRUPT
                        InterruptMicro interruptCommand = new InterruptMicro(microWave);
                        deviceButtons.addButtonCommand(interruptCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==6){
                        break;
                    }
                    else if(userInputDepth2==-1){  //UNDO
                        deviceButtons.pressUndo();
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(dishWasher.getDeviceNr()==userInput){
                    dishWasher.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){
                        if(!dishWasher.getIsOn()){  //SWITCH ON
                            SwitchOnDishwasher onCommand = new SwitchOnDishwasher(dishWasher);
                            deviceButtons.addButtonCommand(onCommand);
                            deviceButtons.press();
                        }
                        else{  //SWITCH OFF
                            SwitchOffDishwasher offCommand = new SwitchOffDishwasher(dishWasher);
                            deviceButtons.addButtonCommand(offCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==1){  //BACK
                        if(!dishWasher.getIsOn()){  //device is currently off, so this is Back Button
                            break;
                        }
                        else{  //START DISHWASHER
                            StartDishwasher startCommand = new StartDishwasher(dishWasher);
                            deviceButtons.addButtonCommand(startCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==2){  //CHOOSE PROGRAM
                        dishWasher.displayPrograms();
                        int userInputDepth4 = createUserInput(5);
                        SelectProgramDishwasher programCommand = new SelectProgramDishwasher(dishWasher,userInputDepth4);
                        deviceButtons.addButtonCommand(programCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //CHECK TIMER
                        CheckTimerDishwasher checkTimeCommand = new CheckTimerDishwasher(dishWasher);
                        deviceButtons.addButtonCommand(checkTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //INTERRUPT
                        InterruptDishwasher interruptCommand = new InterruptDishwasher(dishWasher);
                        deviceButtons.addButtonCommand(interruptCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //BACK
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
                        if(!washingMachine.getIsOn()){  //SWITCH ON
                            SwitchOnWashingmachine onCommand = new SwitchOnWashingmachine(washingMachine);
                            deviceButtons.addButtonCommand(onCommand);
                            deviceButtons.press();
                        }
                        else{  //SWITCH OFF
                            SwitchOffWashingmachine offCommand = new SwitchOffWashingmachine(washingMachine);
                            deviceButtons.addButtonCommand(offCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==1){
                        if(!washingMachine.getIsOn()){  //BACK
                            break;
                        }
                        else{  //START
                            StartWashingmachine startCommand = new StartWashingmachine(washingMachine);
                            deviceButtons.addButtonCommand(startCommand);
                            deviceButtons.press();
                        }
                    }
                    else if(userInputDepth2==2){  //SELECT DEGREES
                        washingMachine.displayDegreeSelection();
                        int userInputDepth3 = createUserInput(6);
                        SetTemperatureWashingmachine setTempCommand = new SetTemperatureWashingmachine(washingMachine,
                                userInputDepth3);
                        deviceButtons.addButtonCommand(setTempCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //SELECT PROGRAM
                        washingMachine.displayPrograms();
                        int userInputDepth4 = createUserInput(5);
                        SelectProgramWashingmachine programCommand = new SelectProgramWashingmachine(washingMachine,
                                userInputDepth4);
                        deviceButtons.addButtonCommand(programCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //INTERRUPT
                        InterruptWashingmachine interruptCommand = new InterruptWashingmachine(washingMachine);
                        deviceButtons.addButtonCommand(interruptCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //BACK
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(cleaningRobot.getDeviceNr()==userInput){
                    cleaningRobot.displayFunctionMenu();
                    int userInputDepth2 = createUserInput(2);
                    if(userInputDepth2==0){  //SET TIMER
                        int userInputDepth3 = createUserInput(3);
                        SetTimerRobo setTimeCommand = new SetTimerRobo(cleaningRobot,userInputDepth3);
                        deviceButtons.addButtonCommand(setTimeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==1){  //START CLEANING
                        StartRobo startCommand = new StartRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(startCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==2){  //CHECK CLEANING PROGRESS
                        CheckCompletionRobo checkProgressCommand = new CheckCompletionRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(checkProgressCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==3){  //CHECK BATTERY STATUS
                        CheckBatteryStatusRobo checkBStatusCommand = new CheckBatteryStatusRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(checkBStatusCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==4){  //CHECK CHARGING STATUS
                        CheckBatteryChargingRobo checkCStatusCommand = new CheckBatteryChargingRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(checkCStatusCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==5){  //COMPLETE CLEANING
                        CompleteCleaningRobo completeCommand = new CompleteCleaningRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(completeCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==6){  //INTERRUPT
                        InterruptRobo interruptCommand = new InterruptRobo(cleaningRobot);
                        deviceButtons.addButtonCommand(interruptCommand);
                        deviceButtons.press();
                    }
                    else if(userInputDepth2==7){  //BACK
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

        Commands.Oven.SwitchOnOven onCommand = new Commands.Oven.SwitchOnOven(newDevice);
        DeviceButton turnOnPressed = new DeviceButton(onCommand);
        turnOnPressed.press();

        Commands.Oven.SwitchOffOven offCommand = new Commands.Oven.SwitchOffOven(newDevice);
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
                System.out.println("Select a specific program (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 6){
                System.out.println("Select the desired Degree Celsius for your washing (Enter the corresponding #): ");
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

    public static CleaningRobot getRobo(){
        return cleaningRobot;
    }

}
