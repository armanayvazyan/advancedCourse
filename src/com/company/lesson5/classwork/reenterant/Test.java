package com.company.lesson5.classwork.reenterant;

public class Test {

    public static void main(String[] args) {

        Counter c = new Counter();

        CounterThread c1 = new CounterThread("C1", c);
        CounterThread c2 = new CounterThread("C2", c);

        c1.start();
        c2.start();

        // Condition check at homework


    }
}
