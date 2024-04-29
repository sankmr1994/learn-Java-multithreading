package com.learn.threads.michaelPogrebinsky_videos.threadCreations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

    public static final int MAX_PWD = 9999;

    public static void main(String[] args) {

        Random randomPwd = new Random();

        Vault vault = new Vault(randomPwd.nextInt(MAX_PWD));

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PolicThread());

        for (Thread thread : threadList)
            thread.start();

    }
}
