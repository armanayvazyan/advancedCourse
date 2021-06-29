package com.company.lesson5.classwork.executorandpools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class TestComplete {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        List<Callable<String>> collables = new ArrayList<>(Arrays.asList(TestComplete::getHi2,TestComplete::getHi2,TestComplete::getHi2, TestComplete::getHi3));

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.invokeAny(collables, 40000, TimeUnit.MILLISECONDS);
        service.shutdown();
    }

    private static String getHi1() {
        System.out.println("hi 1");
        return "Hi 1"; }
    private static String getHi2() throws InterruptedException {
        System.out.println("hi 2");
        Thread.sleep(1000);
        System.out.println("after wait 2");
        return "Hi 2";}
    private static String getHi3() {
        System.out.println("hi 3");
        return "Hi 3"; }
}
