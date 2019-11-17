package Devices;

import Interfaces.*;
import Enumerations.OvenPrograms;

public class Oven implements OnOffInterface, TemperatureInterface, StartStopProgramInterface , TimerInterface, ProgramInterface {

    private boolean isOn = false;
    private boolean running = false;
    private int timer;
    private int lastTimer;
    private int temperature;
    private OvenPrograms program;

    @Override
    public void switchOn() {isOn = true; System.out.println("Devices.Oven is On");}

    @Override
    public void switchOff() {isOn = false; System.out.println("Devices.Oven is Off");}

    @Override
    public void start() {
        if (!isOn){
            System.out.println("Devices.Oven is not On yet");
        }
        if(temperature == 0){
            System.out.println("Temperature not set");
        }
        if(timer == 0){
            System.out.println("Timer not set");
        }
        if(program == null){
            System.out.println("Program not set");
        }
        else{
            this.running = true;
        }
    }

    @Override
    public void stop() {
        if(this.running) {
            this.running = false;
        }
    }

    @Override
    public void upTimer() {
        this.timer += 10;
    }

    @Override
    public void setTimer(int s) {this.timer = s;}

    @Override
    public void upTemperature() {
        this.temperature += 10;
    }

    @Override
    public void downTemperature() {
        this.temperature -= 10;
    }

    @Override
    public void setProgram(OvenPrograms prog) {
        this.program = prog;
    }
}
