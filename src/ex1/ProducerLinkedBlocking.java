package ex1;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerLinkedBlocking extends Thread {
    LinkedBlockingQueue<Integer> queue;

    public ProducerLinkedBlocking(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(new Random().nextInt(30));
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}
