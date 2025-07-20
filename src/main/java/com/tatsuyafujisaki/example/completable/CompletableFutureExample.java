package com.tatsuyafujisaki.example.completable;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/// [CompletableFuture](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        example1();
        example2();
    }

    private static void example1() {
        mockThirdPartyApi()
                .whenComplete((data, throwable) -> {
                            if (throwable == null) {
                                System.out.println(data);
                            } else {
                                System.err.println(throwable.getMessage());
                            }
                        }
                );
    }

    private static void example2() {
        try {
            System.out.println(mockThirdPartyApi().join());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static CompletableFuture<String> mockThirdPartyApi() {
        var future = new CompletableFuture<String>();
        mockThirdPartyCallbackApi(future::complete, future::completeExceptionally);
        return future;
    }

    /// Mock third-party API that does not return a value, but rather takes callbacks and provides a success or failure value via one of them.
    private static void mockThirdPartyCallbackApi(Consumer<String> onSuccess, Consumer<Exception> onError) {
        try {
            mayThrowException();
            onSuccess.accept("🍎");
        } catch (Exception e) {
            onError.accept(e);
        }
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
