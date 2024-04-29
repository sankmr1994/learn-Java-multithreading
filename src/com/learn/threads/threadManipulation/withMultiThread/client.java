package com.learn.threads.threadManipulation.withMultiThread;

public class client {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        //Sequential execution
        System.out.println("Main method Started by thread : " + Thread.currentThread().getName());
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();
        Thread runnable1Thread = new Thread(runnable1);
        Thread runnable2Thread = new Thread(runnable2);
        runnable1Thread.start();
        runnable2Thread.start();

        try {
            runnable1Thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main method Ended by thread : " + Thread.currentThread().getName());

        long endTime = System.currentTimeMillis();

        System.out.println("Total time to complete : " + (endTime - startTime));
    }
}
