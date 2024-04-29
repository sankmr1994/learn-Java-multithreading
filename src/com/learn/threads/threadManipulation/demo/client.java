package com.learn.threads.threadManipulation.demo;

public class client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started by " + Thread.currentThread().getName());
        RunnableImpl runnable1 = new RunnableImpl();
        RunnableImpl runnable2 = new RunnableImpl();
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable1);
        Thread t3 = new Thread(runnable2);
        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();

        System.out.println("Ended by " + Thread.currentThread().getName());

        System.out.println(runnable1.value);
        System.out.println(runnable2.value);

    }
}
