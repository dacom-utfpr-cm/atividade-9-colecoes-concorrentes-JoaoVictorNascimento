/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Implemente duas versões do problema do produtor/consumidor com M produtores e N consumidores usando
    ArrayBlockingQueue e LinkedBlockingQueue.
    Compare o desempenho das duas implementações.
 */
package ex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        ArrayList<Thread> arrayblockingthreads = new ArrayList<Thread>();
        ArrayList<Thread> linkedBlockingThreads = new ArrayList<Thread>();
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(6);
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(6);
        Date arrayBlockingTime = new Date();
        Date linkedBlockingTime = new Date();


        for(int i = 0; i < 10; i++){
            Thread thread = new ProducerArrayBlockingQueue(arrayBlockingQueue);
            thread.start();
        }

        for(int i = 0; i < 10; i++){
            Thread thread = new ConsumerArrayBlockingQueue(arrayBlockingQueue);
            thread.start();
        }

        for (Thread thread: arrayblockingthreads) {
            try {
                thread.join();
            } catch (InterruptedException error){
                error.printStackTrace();
            }
        }

        for(int i = 0; i < 10; i++){
            Thread thread = new ProducerLinkedBlocking(linkedBlockingQueue);
            thread.start();
        }

        for(int i = 0; i < 10; i++){
            Thread thread = new ConsumerLinkedBlockingQueue(linkedBlockingQueue);
            thread.start();
        }

        for (Thread thread: linkedBlockingThreads) {
            try {
                thread.join();
            } catch (InterruptedException error){
                error.printStackTrace();
            }
        }

        System.out.println("ArrayBlockingQueue Runtime : " + (new Date().getTime() - arrayBlockingTime.getTime()));
        System.out.println("LinkedBlockingQueue Runtime : " + (new Date().getTime() - linkedBlockingTime.getTime()));


    }

}
