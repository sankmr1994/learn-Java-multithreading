package com.learn.threads.threadManipulation.interThreadCommunication;

import java.util.stream.IntStream;

public class SynchronizeSameIntrinsicLock {
    public static int value1 = 0;
    public static int value2 = 0;


    public static void increament1() {
        System.out.println("Incrementing by : " + Thread.currentThread().getName());
        synchronized (SynchronizeSameIntrinsicLock.class) {
            value1++;
        }
    }

    public static void increament2() {
        System.out.println("Incrementing by : " + Thread.currentThread().getName());
        synchronized (SynchronizeSameIntrinsicLock.class) {
            value2++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(() -> {
            IntStream.rangeClosed(1, 100).forEach(v -> {
                increament1();
            });
        });

        Thread t2 = new Thread(() -> {
            IntStream.rangeClosed(1, 100).forEach(v -> {
                increament2();
            });
        });

        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName() + "Waiting for t1 and t2 to complete");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Value1 is : " + value1);
        System.out.println("Value2 is : " + value2);
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1).forEach(v -> {
            process();
        });
    }
}
