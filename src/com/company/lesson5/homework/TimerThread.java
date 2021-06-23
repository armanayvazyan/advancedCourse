package com.company.lesson5.homework;

public class TimerThread extends Thread {

    private Counter counter;

    public TimerThread(Counter counter) {
        this.setName("TimerThread");
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            counter.count();
        }
    }
}
