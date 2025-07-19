package com.tatsuyafujisaki.example.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/// [CompletableFuture](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
public class CallableToCompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fetchDataOrErrorAsync()
                .whenComplete((data, throwable) -> System.out.println(throwable != null ? throwable.getMessage() : data));
    }

    public static CompletableFuture<String> fetchDataOrErrorAsync() {
        CompletableFuture<String> future = new CompletableFuture<>();

        fetchDataOrError(
                future::complete,
                future::completeExceptionally
        );

        return future;
    }

    private static void fetchDataOrError(Consumer<String> onSuccess, Consumer<Exception> onError) {
        try {
            Thread.sleep(100);
            maybeThrowException();
            onSuccess.accept("🍎");
        } catch (Exception e) {
            onError.accept(e);
        }
    }

    private static void maybeThrowException() throws RuntimeException {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("💀");
        }
    }
}
