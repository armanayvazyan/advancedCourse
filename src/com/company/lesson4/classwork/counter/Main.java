package com.company.lesson4.classwork.counter;

public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter();
        MyThread myThread = new MyThread("T1", counter);
        myThread.start();

        MyThread myThread2 = new MyThread("T2", counter);
        myThread2.start();

        MyThread myThread3 = new MyThread("T3", counter);
        myThread3.start();


    }
}
