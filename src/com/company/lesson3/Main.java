package com.company.lesson3;

public class Main {

    public static void main(String[] args) {

        Thread maxThread = new Thread(new Timer(4,5));

        maxThread.start();
    }
}
