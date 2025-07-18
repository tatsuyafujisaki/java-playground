package com.tatsuyafujisaki.example.functional;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        predicateExample();
        System.out.println("--");

        intPredicateExample();
        System.out.println("--");

        doublePredicateExample();
        System.out.println("--");

        biPredicateExample();
        System.out.println("--");
    }

    @SuppressWarnings("ConstantConditions")
    private static void predicateExample() {
        Predicate<String> predicate = (fruit) -> fruit.equals("🍎");
        System.out.println(predicate.test("🍎"));
    }

    @SuppressWarnings("ConstantConditions")
    private static void intPredicateExample() {
        IntPredicate isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(2));
    }

    @SuppressWarnings("ConstantConditions")
    private static void doublePredicateExample() {
        DoublePredicate inRange = x -> x >= 0.0 && x <= 10.0;
        System.out.println(inRange.test(3.14));
    }

    @SuppressWarnings("ConstantConditions")
    private static void biPredicateExample() {
        BiPredicate<String, String> biPredicate = (fruit1, fruit2) -> fruit1.equals("🍎") && fruit2.equals("🍊");
        System.out.println(biPredicate.test("🍎", "🍊"));
    }
}
