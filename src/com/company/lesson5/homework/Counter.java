package com.company.lesson5.homework;

import javax.swing.*;

public class Counter {

    private int minutes;
    private int seconds;

    private JLabel minutesLabel;
    private JLabel secondsLabel;

    public Counter(int minutes, int seconds, JLabel minutesLabel, JLabel secondsLabel) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.minutesLabel = minutesLabel;
        this.secondsLabel = secondsLabel;
    }

    public void count() {
        boolean isAlive = true;
        boolean isFirstIteration = true;
        while (isAlive) {
            if (minutes == 0) {
                isAlive = false;
            }
            for (int i = isFirstIteration ? seconds : 59; i >= 0; i--) {
                isFirstIteration = false;
                minutesLabel.setText(minutes < 10 ? "0" + minutes + "m" : minutes + "m");
                secondsLabel.setText(i < 10 ? "0" + i + "s" : i + "s");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            minutes--;
        }
    }
}
