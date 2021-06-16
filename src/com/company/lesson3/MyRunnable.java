package com.company.lesson3;

public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(name +":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { // check which case can have this exception
                e.printStackTrace();
            }
        }
    }
}
