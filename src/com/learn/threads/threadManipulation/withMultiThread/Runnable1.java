package com.learn.threads.threadManipulation.withMultiThread;

import java.util.stream.IntStream;

public class Runnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable-1 Started by thread : " + Thread.currentThread().getName());
        IntStream.rangeClosed(1, 10).forEach(val -> {
            System.out.println("Runnable-1 " + val);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Runnable-1 Ended by thread : " + Thread.currentThread().getName());
    }
}
