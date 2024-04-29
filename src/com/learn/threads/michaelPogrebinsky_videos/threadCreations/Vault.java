package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

public class Vault {

    private int password;

    Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int passwordGuess) throws InterruptedException {
        Thread.sleep(5);
        return this.password == passwordGuess;
    }
}
