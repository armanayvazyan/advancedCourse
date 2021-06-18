package com.company.lesson4.classwork.counter;

import java.util.concurrent.TimeUnit;

// Object monitor  read
public class Counter {

    private int flag = 1;

    public synchronized void count(String name) {
        for (int i = 1; i < 11; i++) {
            System.out.println(name + ": " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(flag == 1 && i == 5) {
                flag = 2;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(flag == 2 && i ==6) {
                flag = 3;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(flag == 3 && i == 10) {
                flag = 0;
                notifyAll();
            }
        }
    }
}
