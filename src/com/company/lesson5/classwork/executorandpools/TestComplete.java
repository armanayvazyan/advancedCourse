package com.company.lesson5.classwork.executorandpools;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class TestComplete {

    public static void main(String[] args) {
        // Completable future

        ExecutorService service = Executors.newSingleThreadExecutor();

        CompletableFuture.supplyAsync(getHi(), service);
    }

    private static Supplier<String> getHi() {
        return () -> "Hi";
    }
}
