package ex1;

import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerArrayBlockingQueue extends Thread {
    ArrayBlockingQueue<Integer> arrayBlockingQueueue;

    public ConsumerArrayBlockingQueue(ArrayBlockingQueue<Integer> arrayBlockingQueueue) {
        this.arrayBlockingQueueue = arrayBlockingQueueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(arrayBlockingQueueue.take());
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}
