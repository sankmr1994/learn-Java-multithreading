package com.learn.threads.threadManipulation.withoutMultiThread;

import java.util.stream.IntStream;

public class Runnable2 {

    public void run() {
        System.out.println("Runnable-2 Started by thread : " + Thread.currentThread().getName());
        IntStream.rangeClosed(1, 10).forEach(val -> {
            System.out.println("Runnable-2 " + val);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Runnable-2 Ended by thread : " + Thread.currentThread().getName());
    }
}
