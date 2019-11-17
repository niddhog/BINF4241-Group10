public class Timer implements Runnable {


    private boolean running;    // represent the state of the thread
    private int time;           // represent the time of life of the thread

    /**
     * Constructor for MyThread
     * @param timeInMillis: time of life of the thread
     * */
    public Timer(int timeInMillis){
        time = timeInMillis;
        running = false;
    }

    /**
     * Default Constructor. It has a default time of 10 seconds.
     * */
    public Timer(){
        this(10*1000);
    }

    /**
     * This method check if the thread is running
     * @return the state of the thread
     * */
    public boolean isRunning(){
        return running;
    }

    /**
     * This method contains the behaviour of the thread. Its implementation
     * is mandatory. In this case, the thread will sleep for the amount of time
     * specified in the constructor and handle the state of the Thread.
     * */
    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(time);
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
