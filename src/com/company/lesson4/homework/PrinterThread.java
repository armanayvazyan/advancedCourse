package com.company.lesson4.homework;

public class PrinterThread extends Thread {

    private boolean exit;
    private FinderThread finder;

    public PrinterThread(String name, FinderThread finder) {
        this.setName(name);
        this.finder = finder;
    }

    @Override
    public void run() {
        while(!exit) {
            try {
                Thread.sleep(200);
                double input = (double) finder.getSize() / 1000000000;
                String size = String.format("%.3f", input);
                System.out.println( size + " GB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!finder.isAlive()) {
                exit = true;
            }
        }
    }
}
