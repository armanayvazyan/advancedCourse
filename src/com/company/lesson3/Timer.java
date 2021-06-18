package com.company.lesson3;

import java.time.DateTimeException;

public class Timer implements Runnable{

    int minutes = 0;
    int seconds = 0;

    public Timer(int minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 60))
            throw new DateTimeException("Wrong time was set");
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int i = minutes; i >= 0; i--) {
            if (i == minutes) {
                for (int j = seconds; j >= 0; j--) {
                    printTime(i, j);
                    sleep(1000);

                }
            } else {
                for (int j = 59; j >= 0; j--) {
                    printTime(i, j);
                    sleep(1000);
                }
            }
        }
    }

    private static void printTime(int minutes, int seconds) {
        if(minutes < 10)
            System.out.print("0" + minutes + "m:");
        else
            System.out.print(minutes + "m:");
        if(seconds < 10)
            System.out.print("0" + seconds + "s");
        else
            System.out.print(seconds + "s");
        System.out.println();
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
