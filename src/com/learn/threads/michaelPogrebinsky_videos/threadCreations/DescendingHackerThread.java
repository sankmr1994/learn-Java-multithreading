package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class DescendingHackerThread extends HackerThread {

    DescendingHackerThread(Vault vault) {

        super(vault);
    }

    @Override
    public void run() {
        for (int guess = Client.MAX_PWD; guess >= 1; guess--) {
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
