package com.tatsuyafujisaki.example.functional;

import java.util.function.*;

public class ConsumerExample {
    public static void main(String[] args) {
        consumerExample();
        System.out.println("--");

        intConsumerExample();
        System.out.println("--");

        doubleConsumerExample();
        System.out.println("--");

        biConsumerExample();
        System.out.println("--");

        objIntConsumerExample();
        System.out.println("--");
    }

    private static void consumerExample() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("🍎");
    }

    private static void intConsumerExample() {
        IntConsumer consumer = System.out::println;
        consumer.accept(1);
    }

    private static void doubleConsumerExample() {
        DoubleConsumer consumer = System.out::println;
        consumer.accept(1.2);
    }

    private static void biConsumerExample() {
        BiConsumer<String, String> biConsumer = (emoji, name) -> System.out.println(emoji + name);
        biConsumer.accept("🍎", "Apple");
        biConsumer.accept("🍊", "Orange");
    }

    private static void objIntConsumerExample() {
        ObjIntConsumer<String> biConsumer = (name, price) -> System.out.println(name + price);
        biConsumer.accept("🍎", 1);
        biConsumer.accept("🍊", 2);
    }

    private static void objDoubleConsumerExample() {
        ObjDoubleConsumer<String> biConsumer = (name, price) -> System.out.println(name + price);
        biConsumer.accept("🍎", 1.2);
        biConsumer.accept("🍊", 3.4);
    }
}
