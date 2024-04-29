package com.learn.threads.threadManipulation.threadExecutors;

public class MyTask1 implements Runnable {


    @Override
    public void run() {
        System.out.println("Task-1 started by : " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println("Task-1 : " + i + " by " + Thread.currentThread().getName());
        }
        System.out.println("Task-1 ended by : " + Thread.currentThread().getName());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
