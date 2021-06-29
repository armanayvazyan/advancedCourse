package com.company.lesson4.homework;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FinderThread finder = new FinderThread("FinderThread", Path.of("/Users/armanayvazyan/Desktop"));
        PrinterThread printerThread = new PrinterThread("PrinterThread", finder);

        finder.start();
        printerThread.start();

        finder.join();
        printerThread.join();

        System.out.println("Total count of items: " + finder.getCount());
    }
}
