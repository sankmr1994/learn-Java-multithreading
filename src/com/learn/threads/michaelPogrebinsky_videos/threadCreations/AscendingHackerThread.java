package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class AscendingHackerThread extends HackerThread {

    AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = 1; guess < Client.MAX_PWD; guess++) {
            try {
                System.out.println(this.getName() + " Guessing number :  " + guess);
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the pwd :  " + guess);
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
