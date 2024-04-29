package com.learn.threads.threadManipulation.demo;

public class WaitNotifyExample {

    private void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producing value");
            this.wait();
            System.out.println("completed");
        }
    }

    private void consumer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Consuming value");
            this.notify();
            System.out.println("Consuming completed");
            Thread.sleep(10000);
            System.out.println("Consuming completed");

        }
    }


    public static void main(String[] args) throws InterruptedException {

        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();

        Thread t1 = new Thread(() -> {
            try {
                waitNotifyExample.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                waitNotifyExample.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
