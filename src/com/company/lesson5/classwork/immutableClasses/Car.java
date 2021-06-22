package com.company.lesson5.classwork.immutableClasses;

public class Car {

    private final String model;
    private final int year;
    private final Engine engine;


    public Car(String model, int year, Engine engine) {
        this.model = model;
        this.year = year;
        this.engine = engine == null ? null : new Engine(engine.getType(), engine.getSize());
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return new Engine(engine.getType(), engine.getSize());
    }
}
