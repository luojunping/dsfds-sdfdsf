package com.ljp.test.crontab;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer("timerTest");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world !!!");
            }
        }, 1000, 1000);
    }
}
