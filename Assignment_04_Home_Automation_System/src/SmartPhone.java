import Commands.*;
import Devices.Oven;
import Enumerations.OvenPrograms;

public class SmartPhone {

    public static void main(String[] args) {

        Oven oven = new Oven();

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


    }
}
