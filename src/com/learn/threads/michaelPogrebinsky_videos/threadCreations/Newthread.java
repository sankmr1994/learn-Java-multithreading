package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class Newthread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from " + this.getName());
    }
}
