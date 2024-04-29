package com.learn.threads.threadManipulation.threadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedSizeThreadExecutorExample {


    public static void main(String[] args) throws InterruptedException {
        MyTask1 myTask1 = new MyTask1();
        MyTask2 myTask2 = new MyTask2();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 1; i++) {
            executorService.submit(myTask1);
            executorService.submit(myTask2);
        }

    }

}
