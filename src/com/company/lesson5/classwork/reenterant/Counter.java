package com.company.lesson5.classwork.reenterant;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void count(String name) {
        reentrantLock.lock();
        System.out.println("Starting count");
        for (int i = 0; i < 11 ; i++) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printHello() {
        System.out.println("Hello from Counter");
    }

    public void finishLock() {
        System.out.println("Finishing lock");
        reentrantLock.unlock();
    }

}
