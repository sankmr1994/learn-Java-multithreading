package com.learn.threads.threadManipulation.threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutorExample {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new MyTask1(), 1000, 2000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new MyTask2(), 1000, 2000, TimeUnit.MILLISECONDS);

    }
}
