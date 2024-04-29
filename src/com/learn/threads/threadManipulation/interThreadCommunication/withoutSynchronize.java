package com.learn.threads.threadManipulation.interThreadCommunication;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class withoutSynchronize {


    public static int value = 0;

    public static void increament() {
        System.out.println("Incrementing by : " + Thread.currentThread().getName());
        value++;
    }


    public static void process() {
        Thread t1 = new Thread(() -> {
            IntStream.rangeClosed(1, 100).forEach(v -> {
                increament();
            });
        });

        Thread t2 = new Thread(() -> {
            IntStream.rangeClosed(1, 100).forEach(v -> {
                increament();
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

        // because of shared value for both t1 and t2 result may not correct
        System.out.println("Value is : " + value);
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(v -> {
            process();
            value = 0;
        });
    }
}
