package com.company.lesson5.classwork.immutableClasses;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Human human = new Human("Arman", new Date(1996, 20, 4));

        Car c = new Car("BMW", 2000, new Engine("Petrol", 200));




    }

}
