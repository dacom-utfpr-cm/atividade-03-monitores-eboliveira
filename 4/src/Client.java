public class Client implements Runnable {

    private Barber barber;

    public void clientIn() throws InterruptedException {
        synchronized (barber){
            String response = barber.getSeat();
            if(response.equals("getted")){
                Thread.sleep(1000);
                barber.clientOut();
            }else if(response.equals("wait")){
                wait();
                Thread.sleep(1000);
                barber.clientOut();
            }else{
                return;
            }
        }
    }

    Client(Barber barber){
        this.barber = barber;
    }

    @Override
    public void run() {
        try {
            clientIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
