package com.tatsuyafujisaki.example.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/// [CompletableFuture](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
public class CallableToCompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fetchDataOrErrorAsync()
                .whenComplete((data, throwable) -> {
                            if (throwable == null) {
                                System.out.println(data);
                            } else {
                                System.err.println(throwable.getMessage());
                            }
                        }
                );
    }

    public static CompletableFuture<String> fetchDataOrErrorAsync() {
        var future = new CompletableFuture<String>();
        fetchDataOrError(future::complete, future::completeExceptionally);
        return future;
    }

    private static void fetchDataOrError(Consumer<String> onSuccess, Consumer<Exception> onError) {
        try {
            Thread.sleep(100);
            mayThrowException();
            onSuccess.accept("🍎");
        } catch (Exception e) {
            onError.accept(e);
        }
    }

    private static void mayThrowException() throws RuntimeException {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("💀");
        }
    }
}
