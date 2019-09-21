import java.util.Random;

public class Producer implements Runnable {
    private final Monitor monitor;
    private String alphabet = "0123456789ABCDE";
    Random r = new Random();

    @Override
    public void run() {
        while (true){
            try {
                char write_char = alphabet.charAt(r.nextInt(alphabet.length()));
                monitor.write(write_char);
                System.out.println("Escrevi: " + write_char);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Producer(Monitor monitor){
        this.monitor = monitor;
    }
}
