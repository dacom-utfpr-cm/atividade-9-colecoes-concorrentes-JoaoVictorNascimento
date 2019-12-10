package ex2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;

public class Consumer extends Thread {
    int numCards = 0;
    PriorityBlockingQueue<Card> cards;
    CyclicBarrier producBarrier;
    CyclicBarrier consumBarrier;

    public Consumer(PriorityBlockingQueue<Card> cards, CyclicBarrier producBarrier, CyclicBarrier consumBarrier) {
        this.cards = cards;
        this.producBarrier = producBarrier;
        this.consumBarrier = consumBarrier;
    }

    @Override
    public void run() {
        try {
            while(true) {
                if (numCards == 0) {
                    //Esperando o término da produção dos produtores
                    producBarrier.await();
                }
                Thread.sleep(200);
                System.out.println(cards.take());
                numCards++;
                if (numCards == 3) {
                    numCards = 0;
                    System.out.println("Consumer drew 3 cards");
                    consumBarrier.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
