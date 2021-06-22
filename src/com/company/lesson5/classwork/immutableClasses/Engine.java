package com.company.lesson5.classwork.immutableClasses;

public class Engine {

    private String type;
    private int size;

    public Engine(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
