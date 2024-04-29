package com.learn.threads.threadManipulation.deadLocalExample;

public class ThreadB extends Thread {

    ThreadA threadA;

    ThreadB() {
    }

    @Override
    public void run() {
        threadBTask();
    }

    private synchronized void threadBTask() {
        System.out.println(this.getName() + " inside threadATask method.");
        System.out.println(this.getName() + " trying to call threadBLastTask method.");
        threadA.threadALastTask();

    }

    synchronized void threadBLastTask() {
        System.out.println(this.getName() + " inside threadBLastTask method.");
    }

    public void setThreadA(ThreadA threadA) {
        this.threadA = threadA;
    }
}
