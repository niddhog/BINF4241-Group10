package Util;
import Devices.CleaningRobot;

public class roboProgressThread implements Runnable {

    private boolean running;    // represent the state of the thread
    private int seconds;           // represent the time of life of the thread


    public roboProgressThread(){
        seconds = 0;
        running = false;
    }


    public boolean isRunning(){
        return running;
    }  //Check it thread is running

    public void setTime(int timeInMillis){
        seconds = timeInMillis * 719;
    }


    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(seconds);
            running = false;
            System.out.println("ROBOT *BEEP*: CLEANING COMPLETE");
            CleaningRobot robo = UseSmartPhone.getRobo();
            robo.interrupt();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}