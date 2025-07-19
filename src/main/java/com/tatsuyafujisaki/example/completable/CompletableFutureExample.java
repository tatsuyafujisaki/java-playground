package com.tatsuyafujisaki.example.completable;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/// [CompletableFuture](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        voidCompletableFutureExample();
        System.out.println("--");

        nonVoidCompletableFutureExample();
        System.out.println("--");

        exceptionallyExample();
        System.out.println("--");

        exceptionallyComposeExample();
        System.out.println("--");
    }

    private static void voidCompletableFutureExample() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        var future = createCompletableFuture("🍎")
                .thenRun(() -> printKeyValue("thenRun", null))
                .handle((result, throwable) -> formatKeyValue("handle", (throwable != null ? throwable.getMessage() : null)))
                .whenComplete((result, throwable) -> printKeyValue("whenComplete", (throwable != null ? throwable.getMessage() : result)));
        printKeyValue("join", future.join());
    }

    private static void nonVoidCompletableFutureExample() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        var future = createCompletableFuture("🍎")
                .thenApply(s -> formatKeyValue("thenApply", s))
                .thenCombine(createCompletableFuture("🍊"), (s1, s2) -> formatKeyValue("thenCombine", s1 + s2))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> formatKeyValue("thenCompose", s)))
                .handle((result, throwable) -> formatKeyValue("handle", throwable != null ? throwable.getMessage() : result))
                .whenComplete((result, throwable) -> printKeyValue("whenComplete", throwable != null ? throwable.getMessage() : result));
        printKeyValue("join", future.join());
    }

    private static void exceptionallyExample() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        var future = createCompletableFutureThrowingException()
                .exceptionally(throwable -> formatKeyValue("exceptionally", throwable.getMessage()))
                .handle((result, throwable) -> formatKeyValue("handle", throwable != null ? throwable.getMessage() : result))
                .whenComplete((result, throwable) -> printKeyValue("whenComplete", throwable != null ? throwable.getMessage() : result));
        printKeyValue("join", future.join());
    }

    private static void exceptionallyComposeExample() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        var future = createCompletableFutureThrowingException()
                .exceptionallyCompose(throwable -> CompletableFuture.supplyAsync(() -> formatKeyValue("exceptionallyCompose", throwable.getMessage())))
                .handle((result, throwable) -> formatKeyValue("handle", throwable == null ? result : throwable.getMessage()))
                .whenComplete((result, throwable) -> printKeyValue("whenComplete", throwable != null ? throwable.getMessage() : result));
        printKeyValue("join", future.join());
    }

    private static CompletableFuture<String> createCompletableFuture(String s) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofMillis(100));
            return s;
        });
    }

    private static CompletableFuture<String> createCompletableFutureThrowingException() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofMillis(100));
            throw new RuntimeException("💀");
        });
    }

    private static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

    private static void printKeyValue(String key, String value) {
        System.out.println(formatKeyValue(key, value));
    }

    private static String formatKeyValue(String key, Object value) {
        return "(" + key + ": " + value + ")";
    }
}
