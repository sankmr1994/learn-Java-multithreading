package com.learn.threads.threadManipulation.deadLocalExample;

public class ThreadA extends Thread {

    ThreadB threadB;

    ThreadA() {
    }

    @Override
    public void run() {
        threadATask();
    }

    private synchronized void threadATask() {
        System.out.println(this.getName() + " inside threadATask method.");
        System.out.println(this.getName() + " trying to call threadBLastTask method.");
        threadB.threadBLastTask();

    }

    synchronized void threadALastTask() {
        System.out.println(this.getName() + " inside threadALastTask method.");
    }

    public void setThreadB(ThreadB threadB) {
        this.threadB = threadB;
    }
}
