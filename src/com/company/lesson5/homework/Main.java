package com.company.lesson5.homework;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Timer t = new Timer();
            t.setVisible(true);
        });
        thread.start();
    }

}
