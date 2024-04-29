package com.learn.threads.threadManipulation.threadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {


    public static void main(String[] args) {
        System.out.println("Main method Started by : " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 2; i++) {
            executorService.submit(new MyTask1());
            executorService.submit(new MyTask2());
        }

        System.out.println("Main method Ended by : " + Thread.currentThread().getName());
    }
}
