// Autor: Eduardo Barbosa de Oliveira       21/09/2019

// Escreva um monitor BoundedCounter que possui um valor mı́nimo e máximo. A classe possui dois métodos: increment() e decrement().
// Ao alcançar os limites mı́nimo ou máximo, a thread que alcançou deve ser bloqueada.

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedCounter counter = new BoundedCounter(10, 20);
        new Thread(new MyThread(2000, counter, false)).start();
        new Thread(new MyThread(500, counter, true)).start();
        new Thread(new MyThread(100, counter, true)).start();
    }
}
