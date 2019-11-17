import Commands.*;
import Devices.*;
import Enumerations.OvenPrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartPhone {

    static ArrayList<MasterDevice> devices = new ArrayList<MasterDevice>();

    public static void main(String[] args) {

        Oven oven = new Oven("Oven");
        CleaningRobot cr = new CleaningRobot("Cleaning robot");
        DishWasher dw = new DishWasher("Dish washer");
        MicroWave mw = new MicroWave("Micro wave");
        WashingMaschine wm = new WashingMaschine("Washing machine");

        devices.add(oven);
        devices.add(cr);
        devices.add(dw);
        devices.add(mw);
        devices.add(wm);

        TurnDeviceOn ovenOnCommand = new TurnDeviceOn(oven);
        DeviceButton ovenOn = new DeviceButton(ovenOnCommand);

        TurnDeviceOff ovenOffCommand = new TurnDeviceOff(oven);
        DeviceButton ovenOff = new DeviceButton(ovenOffCommand);

        UpTemperature ovenUpTempCommand = new UpTemperature(oven);
        DeviceButton ovenUpTemp = new DeviceButton(ovenUpTempCommand);

        DownTemperature ovenDownTempCommand = new DownTemperature(oven);
        DeviceButton ovenDownTemp = new DeviceButton(ovenDownTempCommand);

        SetProgram ovenGrillCommand = new SetProgram(oven, OvenPrograms.Grill);
        DeviceButton ovenGrill = new DeviceButton(ovenGrillCommand);

        SetProgram ovenBakeCommand = new SetProgram(oven, OvenPrograms.Bake);
        DeviceButton ovenBake = new DeviceButton(ovenBakeCommand);

        SetProgram ovenDefrostCommand = new SetProgram(oven, OvenPrograms.Defrost);
        DeviceButton ovenDefrost = new DeviceButton(ovenDefrostCommand);

        SetProgram ovenVentilateCommand = new SetProgram(oven, OvenPrograms.Ventilate);
        DeviceButton ovenVentilate = new DeviceButton(ovenVentilateCommand);

        SetProgram ovenPlateWarmCommand = new SetProgram(oven, OvenPrograms.PlateWarming);
        DeviceButton ovenPlateWarm = new DeviceButton(ovenPlateWarmCommand);

        while(true){
            Scanner intInput = new Scanner(System.in);
            System.out.println("Welcome to your SmartHome9000, choose which device you wanna manage");

            for(int i=0; i < devices.size(); i++){
                System.out.println(i + " " + devices.get(i).getName());
            }
            int num = intInput.nextInt();
            System.out.println("You chose the " + devices.get(num));
        }
    }
}
