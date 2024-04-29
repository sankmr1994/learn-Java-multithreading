package com.learn.threads.threadManipulation.interThreadCommunication;

public class WaitAndNotifyExample {

    public void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running produce method.");
            this.wait();
            System.out.println("Again in produce method");
        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(5000);
        synchronized (this) {
            System.out.println("Running Consumer method.");
            this.notify();
        }
    }

    public static void main(String[] args) {
        WaitAndNotifyExample waitAndNotifyExample = new WaitAndNotifyExample();
        for (int i = 0; i < 10; i++) {
            Thread producerThread = new Thread(() -> {
                try {
                    waitAndNotifyExample.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread consumerThread = new Thread(() -> {
                try {
                    waitAndNotifyExample.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            producerThread.start();
            consumerThread.start();
            System.out.println("=========================================");
        }
    }
}
