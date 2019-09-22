public class BoundedCounter {

    private int counter;
    private int maxValue;
    private int minValue;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void decrement() throws InterruptedException {
        counter-=1;
        System.out.println("Contador: " + counter);
        if(isBound()) {wait();}
    }

    public synchronized void increment() throws InterruptedException {
        counter+=1;
        System.out.println("Contador: " + counter);
        if(isBound()) { wait(); }
    }

    private boolean isBound(){
        return (this.counter == maxValue || this.counter == minValue);
    }

    BoundedCounter(int minValue, int maxValue){
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
