package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class HackerThread extends Thread {

    public Vault vault;

    HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(MAX_PRIORITY);
    }

    @Override
    public synchronized void start() {
        System.out.println("starting thread : " + this.getName());
        super.start();
    }
}
