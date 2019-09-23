// Autor: Eduardo Barbosa de Oliveira       21/09/2019

// Implemente uma solução para o problema do Barbeiro Dorminhoco usando monitores.
// Descrição: Considere uma barbearia com um barbeiro, uma cadeira de barbeiro e n cadeiras para eventuais clientes esperarem a vez.
// Quando não há clientes, o barbeiro senta-se na cadeira de barbeiro e cai no sono.
// Quando chega um cliente, ele precisa acordar o barbeiro.
// Se outros clientes chegarem enquanto o barbeiro estiver cortando o cabelo de um cliente,
// eles se sentarão (se houver cadeiras vazias) ou sairão da barbearia (se todas as cadeiras estiverem ocupadas).

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Barber barber = new Barber(5);
        new Thread(barber).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
        new Thread(new Client(barber)).start();
    }
}
