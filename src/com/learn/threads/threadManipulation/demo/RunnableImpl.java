package com.learn.threads.threadManipulation.demo;

public class RunnableImpl implements Runnable {

    public int value = 0;

    public RunnableImpl runnable;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " object is " + this);
        synchronized (this) {
            System.out.println("Started by " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("Increment by " + Thread.currentThread().getName());
                value++;
            }
            System.out.println("Ended by " + Thread.currentThread().getName());
        }
    }
}
