
public class MyThread implements Runnable {

    private final Counter counter;
    private int wakeUpValue;

    MyThread(Counter counter, int wakeUpValue){
        this.counter = counter;
        this.wakeUpValue = wakeUpValue;
    }

    @Override
    public void run() {
        try {
            counter.sleepUntil(this.wakeUpValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Acordei! Tempo: " + this.wakeUpValue);
    }
}
