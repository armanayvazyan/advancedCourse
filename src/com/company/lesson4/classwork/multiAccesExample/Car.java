package com.company.lesson4.classwork.multiAccesExample;

public class Car {

    public synchronized void test1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1");
    }

    public synchronized void test2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2");
    }
}
