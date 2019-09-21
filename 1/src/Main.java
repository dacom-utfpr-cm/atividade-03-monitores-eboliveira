// Autor: Eduardo Barbosa de Oliveira       21/09/2019

// Descrição: Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Thread t1 = new Thread(new Producer(monitor));
        Thread t2 = new Thread(new Consumer(monitor));
        t1.start();
        t2.start();
    }
}
