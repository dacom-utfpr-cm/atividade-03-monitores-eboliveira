public class Barber implements Runnable{

    private int waiting;
    private int maxWaiting;
    private boolean isSleeping;

    public synchronized String getSeat() {
        if(isSleeping){
            isSleeping = false;
            System.out.println("Acordei porque tem cliente!");
            return "getted";
        }else{
            if(waiting == maxWaiting){
                System.out.println("Barbearia lotada, cliente indo embora");
                return "full";
            }else{
                waiting+=1;
                System.out.println("Cliente chegou e foi pra espera");
                return "wait";
            }
        }
    }

    public synchronized void clientOut() throws InterruptedException {
        System.out.println("Terminei um cliente");
        if(waiting == 0){
            System.out.println("Sem clientes, vou dormir!");
            isSleeping = true;
            wait();
        }else{
            System.out.println("Cliente na espera");
            waiting-=1;
        }
    }

    Barber(int maxWaiting) throws InterruptedException {
        this.maxWaiting = maxWaiting;
    }

    @Override
    public void run() {
        try {
            synchronized (this){
                isSleeping = true;
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
