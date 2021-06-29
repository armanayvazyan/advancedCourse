package com.company.lesson5.homework;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("Hello Runnable!");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(runnable, 0, 2000, TimeUnit.MILLISECONDS);

        for (int i = 0; i <  10; i++) {
            if(i == 9) {
                scheduledFuture.cancel(false);
            }
            Thread.sleep(1000);
        }
        executorService.shutdown();

    }

}
