package com.learn.threads.michaelPogrebinsky_videos.threadCreations.demo;

import java.math.BigInteger;

public class CalculateSumThread implements Runnable {

    private BigInteger totalSum = BigInteger.ZERO;

    private BigInteger numberOfTimes;

    CalculateSumThread(BigInteger numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    @Override
    public void run() {
        System.out.println("Run method started by : " + Thread.currentThread().getName());
        for (BigInteger i = BigInteger.ONE; i.compareTo(numberOfTimes) <= 0; i = i.add(BigInteger.ONE)) {
            totalSum = totalSum.add(i);
//            System.out.println(Thread.currentThread().getName() + " sum is : " + totalSum);
        }
        System.out.println("Run method ended by : " + Thread.currentThread().getName());
    }

    public BigInteger getTotalSum() {
        return this.totalSum;
    }
}
