package com.company.lesson5.classwork.executorandpools;

import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> submit = service.submit(Test::getHi);
        service.submit(Test::getHi);
        service.submit(Test::getHi);
        service.submit(Test::getHi);
        service.submit(Test::getHi);
        List<Runnable> runnables = service.shutdownNow();

        String s = submit.get();
        System.out.println(s +" End main");
    }


    private static String getHi() {
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello";
    }
}
