// Autor: Eduardo Barbosa de Oliveira       21/09/2019

// Descrição: Escreva uma monitor Counter que possibilita um processo dormir até o contador alcançar um valor.
// A classe Counter permite duas operações: increment() e sleepUntil(int x).

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        new Thread(new MyThread(counter, 5)).start();
        new Thread(new MyThread(counter, 7)).start();
        new Thread(new MyThread(counter, 15)).start();
        new Thread(new MyThread(counter, 20)).start();
        int time = 0;
        while(time < 20){
            counter.increment();
            time+=1;
            System.out.println("Tempo: " + time);
            Thread.sleep(1000);
        }
    }
}
