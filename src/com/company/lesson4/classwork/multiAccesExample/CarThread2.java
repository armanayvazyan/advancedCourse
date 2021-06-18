package com.company.lesson4.classwork.multiAccesExample;

public class CarThread2 extends Thread{

    public Car car;

    public CarThread2(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.test2();
    }
}
