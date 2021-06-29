package com.company.lesson4.homework;

import java.io.File;
import java.nio.file.Path;

public class FinderThread extends Thread {

    private volatile long size = 0;
    private int count = 0;
    private String path;

    public FinderThread(String name, Path path) {
        this.path = path.toString();
        this.setName(name);
    }

    @Override
    public void run() {
        find(path);
    }

    private void find(String path) {
        File[] listFiles = new File(path).listFiles();
        for (File file : listFiles) {
            if (file.isFile()) {
                size += file.length();
                count += 1;
            }
            if (file.isDirectory()) {
                find(file.getPath());
            }
        }
    }

    public int getCount() {
        return count;
    }

    public long getSize() {
        return size;
    }
}
