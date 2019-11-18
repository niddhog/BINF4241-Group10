package Util;
import Devices.CleaningRobot;

public class RoboRechargeThread implements Runnable {

    private boolean running;    // represent the state of the thread
    private int seconds;           // represent the time of life of the thread


    public RoboRechargeThread(){
        seconds = 0;
        running = false;
    }


    public boolean isRunning(){
        return running;
    }  //Check it thread is running

    public void setTime(int timeInMillis){
        seconds = timeInMillis * 250;
    }


    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(seconds);
            running = false;
            CleaningRobot robo = UseSmartPhone.getRobo();
            robo.batteryStatus = 100;
            System.out.println("Robo Recharge Complete!");
            robo.createNewRechargeThread();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
