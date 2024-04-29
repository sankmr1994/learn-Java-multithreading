package com.learn.threads.threadManipulation.interThreadCommunication;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {

    public List<Integer> list = new ArrayList<>();

    public static int LOWER_LIMIT = 0;

    public static int UPPER_LIMIT = 5;

    public int value = 0;

    public final Object lock = new Object();

    public void producer() throws InterruptedException {

        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                } else {
                    System.out.println("Adding value : " + value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public void consumer() throws InterruptedException {

        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for Adding items...");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Removing value : " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerExample producerConsumerExample = new ProducerConsumerExample();

        Thread t1 = new Thread(() -> {
            try {
                producerConsumerExample.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                producerConsumerExample.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
