public class Client implements Runnable {

    private Barber barber;

    public synchronized void clientIn() throws InterruptedException {
        barber.notify();
        String response = barber.getSeat();
        if(response.equals("getted")){
            Thread.sleep(1000);
        }else if(response.equals("wait")){
            wait();
        }
    }

    Client(Barber barber){
        this.barber = barber;
    }

    @Override
    public void run() {
        synchronized (barber) {
            try {
                clientIn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            barber.clientOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
