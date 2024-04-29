package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class PolicThread extends Thread {

    PolicThread() {
        this.setName(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " Count : " + i);
        }
        System.out.println("Caught the hackers");
        System.exit(0);
    }
}
