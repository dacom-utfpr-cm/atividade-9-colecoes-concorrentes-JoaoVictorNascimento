package ex1;

import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerLinkedBlockingQueue extends Thread{
    LinkedBlockingQueue<Integer> linkedBlockingQueue;

    public ConsumerLinkedBlockingQueue(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(linkedBlockingQueue.take());
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}
