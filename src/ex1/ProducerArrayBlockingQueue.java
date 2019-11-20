package ex1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerArrayBlockingQueue extends Thread{
    ArrayBlockingQueue<Integer> arrayBlockingQueueue;

    public ProducerArrayBlockingQueue(ArrayBlockingQueue<Integer> arrayBlockingQueueue) {
        this.arrayBlockingQueueue = arrayBlockingQueueue;
    }

    @Override
    public void run() {
        try {
            arrayBlockingQueueue.put(new Random().nextInt(30));
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}

