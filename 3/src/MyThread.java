
public class MyThread implements Runnable {

    private int delayTime;
    private BoundedCounter boundedCounter;
    private boolean increment;

    MyThread(int delayTime, BoundedCounter boundedCounter, boolean increment){
        this.delayTime = delayTime;
        this.boundedCounter = boundedCounter;
        this.increment = increment;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(increment) { this.boundedCounter.increment(); }
                else { this.boundedCounter.decrement(); }
                Thread.sleep(this.delayTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
