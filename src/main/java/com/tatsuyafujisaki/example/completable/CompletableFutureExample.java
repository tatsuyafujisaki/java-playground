package com.tatsuyafujisaki.example.completable;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        example1();
        System.out.println("--");

        example2();
        System.out.println("--");
    }

    static void example1() throws ExecutionException, InterruptedException {
        var future1 = CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofSeconds(1));
            return "🍎";
        });
        var future2 = CompletableFuture
                .supplyAsync(() -> "🍏")
                .thenApply(s -> s + "🍊")
                .thenCombine(future1, (s1, s2) -> s1 + s2)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "🍇"));
        System.out.println(future2.isDone());
        System.out.println(future2.get());
    }

    static void example2() throws ExecutionException, InterruptedException {
        var future = CompletableFuture
                .supplyAsync(() -> {
                            sleep(Duration.ofSeconds(1));
                            if (Math.random() > 0.5) {
                                throw new RuntimeException("💀");
                            }
                            return "🍎";
                        }
                ).exceptionally(throwable -> throwable.getMessage() + "💦")
                .handle((result, throwable) -> (throwable == null) ? result : throwable.getMessage());
        System.out.println(future.isDone());
        System.out.println(future.get());
        System.out.println(future.complete("a"));

    }

    private static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
