package com.company.lesson5.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Completable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        CompletableFuture<String> combine = combine(service);
        CompletableFuture<String> compose = compose(service);

        System.out.println(combine.get());
        System.out.println(compose.get());
    }


    private static CompletableFuture<String> compose(ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> "Hello 1", service)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"))
                .toCompletableFuture();
    }

    private static CompletableFuture<String> combine(ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> "Hello", service)
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2)
                .toCompletableFuture();
    }

}
