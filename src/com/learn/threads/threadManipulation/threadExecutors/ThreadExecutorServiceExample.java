package com.learn.threads.threadManipulation.threadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            executorService.execute(new Thread(() -> {
                System.out.println("Hi by " + Thread.currentThread().getName());
            }));


            Thread.sleep(100);

        }

        Thread.sleep(2000);
    }

}
