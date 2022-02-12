package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 is daemon !!!");
            }
        });
        t1.setDaemon(true);
        Thread t2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 is not daemon !!!");
            }
        });
        t1.start();
        t2.start();
    }

}
