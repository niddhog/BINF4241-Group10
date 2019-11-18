package Util;

public class MyThread implements Runnable {

    private boolean running;    // represent the state of the thread
    private int seconds;           // represent the time of life of the thread


    public MyThread(){
        seconds = 0;
        running = false;
    }


    public boolean isRunning(){
        return running;
    }  //Check it thread is running

    public void setTime(int timeInMillis){
        seconds = timeInMillis * 1000;
    }


    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(seconds);
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
