package com.learn.threads.threadManipulation.interThreadCommunication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public int value;

    public Lock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            for (int i = 0; i < 10000; i++) {
                value++;
            }
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LockExample lockExample = new LockExample();

        Thread t1 = new Thread(() -> {
            lockExample.increment();
        });

        Thread t2 = new Thread(() -> {
            lockExample.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Value is : " + lockExample.value);
    }

}
