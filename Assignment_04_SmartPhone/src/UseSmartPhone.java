//This is the main Application #IDEA: SINGLETON for each Device (there shouldn't be 2 Ovens)
import java.util.Scanner;
import java.util.List;

public class UseSmartPhone {
    private static int menuDepth = 0;
    private static Oven oven = SmartPhone.getOven();
    private static MicroWave microWave = SmartPhone.getMicroWave();
    private static Dishwasher dishWasher = SmartPhone.getDishwasher();
    private static WashingMachine washingMachine = SmartPhone.getWashingMaschine();
    private static CleaningRobot cleaningRobot = SmartPhone.getCleaningRobot();
    //Todo Make Singletons out of these 5 Classes

    public static void main(String[] args) {
        //List<AllDevices> deviceList = SmartPhone.getDevices();
        displayTitle();

        while(true){  //Starts the main Loop
            displayMainMenu();
            int userInput = createUserInput();
            menuDepth++;
            while(true){
                if(oven.getDeviceNr()==userInput){
                    oven.displayFunctionMenu();
                    int userInputDepth2 = createUserInput();
                    if(userInputDepth2==0){
                        if(!oven.getIsOn()){  //device is currently off
                            SwitchOnOven onCommand = new SwitchOnOven(oven);
                            DeviceButton turnOnPressed = new DeviceButton(onCommand);
                            turnOnPressed.press();
                        }
                        else{
                            //todo implement Off Switch

                        }
                    }
                    else if(userInputDepth2==1){
                        if(!oven.getIsOn()){  //device is currently off, so this is Back Button
                            menuDepth--;
                            break;
                        }
                        else{
                            //todo other Button Function of this position when Oven is On
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
                        menuDepth--;
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(microWave.getDeviceNr()==userInput){
                    microWave.displayFunctionMenu();
                    int userInputDepth2 = createUserInput();
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!microWave.getIsOn()){  //device is currently off, so this is Back Button
                            menuDepth--;
                            break;
                        }
                        else{
                            //todo other Button Function of this position when Oven is On
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
                        menuDepth--;
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(dishWasher.getDeviceNr()==userInput){
                    dishWasher.displayFunctionMenu();
                    int userInputDepth2 = createUserInput();
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!dishWasher.getIsOn()){  //device is currently off, so this is Back Button
                            menuDepth--;
                            break;
                        }
                        else{
                            //todo other Button Function of this position when Oven is On
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
                        menuDepth--;
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(washingMachine.getDeviceNr()==userInput){
                    washingMachine.displayFunctionMenu();
                    int userInputDepth2 = createUserInput();
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!washingMachine.getIsOn()){  //device is currently off, so this is Back Button
                            menuDepth--;
                            break;
                        }
                        else{
                            //todo other Button Function of this position when Oven is On
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
                        menuDepth--;
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else if(cleaningRobot.getDeviceNr()==userInput){
                    cleaningRobot.displayFunctionMenu();
                    int userInputDepth2 = createUserInput();
                    if(userInputDepth2==0){

                    }
                    else if(userInputDepth2==1){
                        if(!cleaningRobot.getIsOn()){  //device is currently off, so this is Back Button
                            menuDepth--;
                            break;
                        }
                        else{
                            //todo other Button Function of this position when Oven is On
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
                        menuDepth--;
                        break;
                    }
                    else{
                        System.out.println("This function does not exists, please select again");
                    }
                }
                else{
                    menuDepth--;
                    System.out.println("This Device does not exists, please select again");
                }

            }

        }





        /*
        CookingDevices newDevice = SmartPhone.getDevice();  //returns all Devices linked to the SmartPhone

        SwitchOnOven onCommand = new SwitchOnOven(newDevice);
        DeviceButton turnOnPressed = new DeviceButton(onCommand);
        turnOnPressed.press();

        SwitchOffOven offCommand = new SwitchOffOven(newDevice);
        DeviceButton turnOffPressed = new DeviceButton(offCommand);
        turnOffPressed.press();

        //-------------------------------------------------------

        Oven oven = new Oven();
        MicroWave microWave = new MicroWave();

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
        System.out.println("+---------------------------+");
        System.out.println("\n");
    }


    private static void displayTitle(){
        System.out.println("   _____                      _   _    _                      ___   ___   ___   ___  ");
        System.out.println("  / ____|                    | | | |  | |                    |__ \\ / _ \\ / _ \\ / _ \\ ");
        System.out.println(" | (___  _ __ ___   __ _ _ __| |_| |__| | ___  _ __ ___   ___   ) | | | | | | | | | |");
        System.out.println("  \\___ \\| '_ ` _ \\ / _` | '__| __|  __  |/ _ \\| '_ ` _ \\ / _ \\ / /| | | | | | | | | |");
        System.out.println("  ____) | | | | | | (_| | |  | |_| |  | | (_) | | | | | |  __// /_| |_| | |_| | |_| |");
        System.out.println(" |_____/|_| |_| |_|\\__,_|_|   \\__|_|  |_|\\___/|_| |_| |_|\\___|____|\\___/ \\___/ \\___/ ");
        System.out.println("\n");
    }


    private static int createUserInput(){
        Scanner userInput = new Scanner(System.in);
        String input = null;

        while (true){
            if(menuDepth == 0){
                System.out.println("Select your Device (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 1){
                System.out.println("Select a device functionality (Enter the corresponding #): ");
                input = userInput.nextLine();
            }
            else if (menuDepth == 2){
                System.out.println("Set the functionality (Please enter a whole Number): ");
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
