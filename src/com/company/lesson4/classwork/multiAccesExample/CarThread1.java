package com.company.lesson4.classwork.multiAccesExample;

public class CarThread1 extends Thread{

    public Car car;

    public CarThread1(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.test1();
    }
}
