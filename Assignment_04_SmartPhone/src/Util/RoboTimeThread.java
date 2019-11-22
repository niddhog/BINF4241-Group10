package Util;
import Devices.CleaningRobot;
import Util.UseSmartPhone;

public class RoboTimeThread extends MyThread {


    @Override
    public boolean isRunning(){
        return running;
    }  //Check it thread is running

    @Override
    public void setTime(int timeInMillis){
        seconds = timeInMillis * 1000;
    }


    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(seconds);
            running = false;
            System.out.println("ROBOT *BEEP*: TIMER DEPLETED");
            CleaningRobot robo = UseSmartPhone.getRobo();
            robo.interrupt();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
