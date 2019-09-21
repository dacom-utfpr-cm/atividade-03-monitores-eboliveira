
public class Consumer implements Runnable {
    private final Monitor monitor;

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Li: " + monitor.read());
                Thread.sleep((10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    Consumer(Monitor monitor){
        this.monitor = monitor;
    }
}
