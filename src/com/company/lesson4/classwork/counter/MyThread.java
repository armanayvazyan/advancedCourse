package com.company.lesson4.classwork.counter;

public class MyThread extends Thread{

    private String name;
    private Counter counter;

    public MyThread(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Thread "+ name + " started");
        counter.count(name);
        System.out.println("Thread "+ name + " ended");
    }
}
