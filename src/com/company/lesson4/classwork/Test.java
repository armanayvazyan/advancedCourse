package com.company.lesson4.classwork;

// happens before
public class Test extends Thread{

    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {

        }
        System.out.println("Thread Finished");
    }

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        t.start();
        Thread.sleep(2000);
        t.isActive = false;
    }
}
