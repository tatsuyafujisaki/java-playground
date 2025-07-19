package com.tatsuyafujisaki.example.completable;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/// [CompletableFuture](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        example1();
        System.out.println("--");
        example2();
    }

    private static void example1() {
        try {
            System.out.println(createCompletableFuture().join());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void example2() {
        createCompletableFuture()
                .handle((data, throwable) -> {
                            if (throwable == null) {
                                System.out.println(data);
                            } else {
                                System.err.println(throwable.getMessage());
                            }
                            return null;
                        }
                ).join();
    }

    private static CompletableFuture<String> createCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
                    sleep(Duration.ofMillis(100));
                    mayThrowException();
                    return "🍎";
                }
        );
    }

    private static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

    private static void mayThrowException() throws RuntimeException {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("💀");
        }
    }
}
