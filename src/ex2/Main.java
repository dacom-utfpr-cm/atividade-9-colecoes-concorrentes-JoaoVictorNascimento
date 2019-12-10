/*
    Autor: João Victor Nascimento
    RA: 1817442

    Descrição: Implemente o problema do produtor/consumidor para uma estrutura
    com os seguintes campos: número, simbolo, naipe, que representa uma carta de baralho.
    A implementação deve possibilitar que após 10 cartas produzidas por dois produtores,
    outros dois consumidores pegarão somente as maiores cartas.
    Os produtores somente devem produzir mais cartas após os consumidores removerem 3 cartas cada um.
    As cartas remanescentes podem continuar na estrutura.
    Use a ordenação do baralho da menor para maior: A, 2, ..., 10, Q, J, K.
 */

package ex2;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier producers = new CyclicBarrier(2);
        CyclicBarrier consumers = new CyclicBarrier(3);
        ArrayList<Thread> threads = new ArrayList<Thread>();
        PriorityBlockingQueue<Card> queue = new PriorityBlockingQueue<Card>(10);

        for (int i = 0; i < 2; i++) {
            threads.add(new Producer(queue, producers, consumers));
            threads.get(threads.size() - 1).start();
        }
        for (int i = 0; i < 3; i++) {
            threads.add(new Consumer(queue, producers, consumers));
            threads.get(threads.size() - 1).start();
        }
    }
}
