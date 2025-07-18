package com.tatsuyafujisaki.example.functional;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        supplierExample();
        System.out.println("--");

        intSupplierExample();
        System.out.println("--");

        doubleSupplierExample();
        System.out.println("--");

        booleanSupplierExample();
        System.out.println("--");
    }

    private static void supplierExample() {
        Supplier<String> supplier = () -> "🍎";
        System.out.println(supplier.get());
    }

    private static void intSupplierExample() {
        IntSupplier supplier = () -> 1;
        System.out.println(supplier.getAsInt());
    }

    private static void doubleSupplierExample() {
        DoubleSupplier supplier = () -> 3.14;
        System.out.println(supplier.getAsDouble());
    }

    private static void booleanSupplierExample() {
        BooleanSupplier supplier = () -> true;
        System.out.println(supplier.getAsBoolean());
    }
}
