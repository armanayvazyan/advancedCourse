package com.company.lesson4.classwork.multiAccesExample;

public class Main {

    public static void main(String[] args) {
        Car c = new Car();

        CarThread1 t1 = new CarThread1(c);
        CarThread2 t2 = new CarThread2(c);

        t1.start();
        t2.start();
    }
}
