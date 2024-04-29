package com.learn.threads.threadManipulation.deadLocalExample;

public class Client {

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.setThreadB(threadB);
        threadB.setThreadA(threadA);

        threadA.start();
        threadB.start();

        System.out.println("End main");

    }
}
