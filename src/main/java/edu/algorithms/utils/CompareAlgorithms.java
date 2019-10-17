package edu.algorithms.utils;

import edu.algorithms.complexity.ComplexityUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompareAlgorithms {

    public static void compare(int count, Supplier<int[]> sourceArraySupplier, Consumer<int[]> algoA, Consumer<int[]> algoB) {
        int[] arr = sourceArraySupplier.get();
        Duration durationA = ComplexityUtils.averageSortArray(count, () -> Arrays.copyOf(arr, arr.length), algoA);
        Duration durationB = ComplexityUtils.averageSortArray(count, () -> Arrays.copyOf(arr, arr.length), algoB);
        System.out.printf("Algorithm A : %d ms VS Algorithm B: %d ms %n %s %n", durationA.toMillis(), durationB.toMillis(), (double) durationA.toMillis() / durationB.toMillis());
    }
}
