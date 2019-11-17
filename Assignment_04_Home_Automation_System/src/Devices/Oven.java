package Devices;


import Enumerations.OvenPrograms;
import Interfaces.*;

public class Oven extends MasterDevice implements OnOffInterface, TemperatureInterface, StartStopProgramInterface, TimerInterface, ProgramInterface, InterruptInterface {

    private boolean isOn = false;
    private boolean running = false;
    private int timer;
    private int lastTimer;
    private int temperature;
    private OvenPrograms program;

    public Oven(String name){
        super.setName(name);
    }

    @Override
    public void switchOn() {
        if(!isOn && !running) {
            isOn = true;
        }
        else{
            System.out.println("Oven is already On.");
        }
    }

    @Override
    public void switchOff() {
        if(isOn && !running) {
            isOn = false;
        }
        else{
            System.out.println("Oven is already Off");
        }
    }

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
            lastTimer = timer;
            this.running = true;
        }
    }

    @Override
    public void stop() {
        if(this.running) {
            this.running = false;
            // TODO: add something to distinguish between stop and interrupt....
        }
    }

    @Override
    public int checkTimer() {
        return timer;
    }

    @Override
    public void upTimer() {
        this.timer += 60;
    }

    @Override
    public void resetTimer() {this.timer = 0;}

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

    @Override
    public void interrupt() {
        if(running && timer!=0 && isOn){
            this.running = false;
            // TODO: add something to distinguish between stop and interrupt....
        }
    }
}
