public class Counter {

    private int counter;

    public synchronized void sleepUntil(int value) throws InterruptedException {
        while(this.counter != value){
            wait();
        }
    }

    public synchronized void increment(){
        counter+=1;
        notifyAll();
    }
}
