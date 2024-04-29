package com.learn.threads.michaelPogrebinsky_videos.threadCreations.demo;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("main method started by : " + Thread.currentThread().getName());

        CalculateSumThread calculateSumThread1 = new CalculateSumThread(BigInteger.valueOf(50));
        CalculateSumThread calculateSumThread2 = new CalculateSumThread(BigInteger.valueOf(20));

        Thread thread1 = new Thread(calculateSumThread1);
        Thread thread2 = new Thread(calculateSumThread2);

        System.out.println("Thread-0 started");
        thread1.start();
        System.out.println("Thread-1 started");
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Result of " + thread1.getName() + " is : " + calculateSumThread1.getTotalSum());
        System.out.println("Result of " + thread2.getName() + " is : " + calculateSumThread2.getTotalSum());


        System.out.println("main method ended by : " + Thread.currentThread().getName());


    }
}
