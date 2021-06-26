package com.company.lesson5.classwork.executorandpools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class fixedThreadPoolImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> a = service.submit(fixedThreadPoolImpl::f2);
        Future<String> b = service.submit(fixedThreadPoolImpl::f3);
        Future<String> c = service.submit(fixedThreadPoolImpl::f2);
        Future<String> d = service.submit(fixedThreadPoolImpl::f3);
        service.shutdown();

        System.out.println(a.get());
        System.out.println(b.get());
        System.out.println(c.get());
        System.out.println(d.get());

    }


    private static String f1() {
        System.out.println("Hi 1");
        return "Hi 1";
    }

    private static String f2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hi 2";
    }

    private static String f3() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hi 3";
    }
}
