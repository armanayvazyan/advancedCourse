package com.company.lesson3;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = () -> timer(0,10);
        Thread maxThread = new Thread(runnable);

        maxThread.start();
    }


    private static void timer(int minute, int second) {
        if (second < 0 && second > 60) {
            System.out.println("Wrong second input");
        }
        if (minute < 0) {
            System.out.println("Wrong minute input");
        }
        for (int i = minute; i >= 0; i--) {
            if (i == minute) {
                for (int j = second; j >= 0; j--) {
                    printTime(i, j);
                    sleep(1000);

                }
            } else {
                for (int j = 59; j >= 0; j--) {
                    printTime(i, j);
                    sleep(1000);
                }
            }
        }
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printTime(int minutes, int seconds) {
        if(minutes < 10)
            System.out.print("0" + minutes + "m:");
        else
            System.out.print(minutes + "m:");
        if(seconds < 10)
            System.out.print("0" + seconds + "s");
        else
            System.out.print(seconds + "s");
        System.out.println();
}
}
