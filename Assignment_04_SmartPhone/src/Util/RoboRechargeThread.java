package Util;
import Devices.CleaningRobot;

public class RoboRechargeThread extends MyThread {


    @Override
    public boolean isRunning(){
        return running;
    }  //Check it thread is running

    @Override
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
