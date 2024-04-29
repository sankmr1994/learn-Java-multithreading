package com.learn.threads.threadManipulation.withoutMultiThread;

public class client {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //Sequential execution
        System.out.println("Main method Started by thread : " + Thread.currentThread().getName());
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();
        runnable1.run();
        runnable2.run();
        System.out.println("Main method Ended by thread : " + Thread.currentThread().getName());

        long endTime = System.currentTimeMillis();

        System.out.println("Total time to complete : " + (endTime - startTime));
    }
}
