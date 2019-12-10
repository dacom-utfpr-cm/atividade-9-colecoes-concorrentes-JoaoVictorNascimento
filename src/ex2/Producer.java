package ex2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {
    PriorityBlockingQueue<Card> cards;
    CyclicBarrier consumerBarrier;
    static Semaphore semaphore = new Semaphore(1);
    CyclicBarrier producerBarrier;

    public Producer(PriorityBlockingQueue<Card> cards, CyclicBarrier producerBarrier, CyclicBarrier consumerBarrier) {
        this.cards = cards;
        this.producerBarrier = producerBarrier;
        this.consumerBarrier = consumerBarrier;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(200);
                semaphore.acquire();

                if (cards.size() < 10) {
                    Card c = Card.cardGenerator();
                    cards.add(c);
                    System.out.println("Generated: " + c);
                    semaphore.release();
                } else {
                    semaphore.release();
                    System.out.println("Waiting for consumers...");
                    //Esperando os consumidores terminarem de consumir
                    producerBarrier.await();
                    consumerBarrier.await();
                    System.out.println("Returning to Produce...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
