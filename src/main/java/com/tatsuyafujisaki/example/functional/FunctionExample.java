package com.tatsuyafujisaki.example.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        functionExample();
        System.out.println("--");

        biFunctionExample();
        System.out.println("--");
    }

    private static void functionExample() {
        Function<String, String> function1 = (s) -> s + "🍏";
        Function<String, String> function2 = (s) -> s + "🍊";
        Function<String, String> function3 = (s) -> s + "🍇";
        System.out.println(function1.andThen(function2).compose(function3).apply("🍎"));
    }

    private static void biFunctionExample() {
        BiFunction<String, String, String> function1 = (s1, s2) -> s1 + s2 + "🍊";
        Function<String, String> function2 = (s) -> s + "🍇";
        System.out.println(function1.andThen(function2).apply("🍎", "🍏"));
    }
}
