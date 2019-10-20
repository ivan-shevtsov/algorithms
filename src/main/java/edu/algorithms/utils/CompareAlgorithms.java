package edu.algorithms.utils;

import edu.algorithms.complexity.ComplexityUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompareAlgorithms {

    public static void compare(int count, Supplier<int[]> sourceArraySupplier, String[] names, Consumer<int[]>... algorithms) {
        int[] arr = sourceArraySupplier.get();
        for (int i = 0; i < algorithms.length; i++) {
            Duration duration = ComplexityUtils.averageSortArray(count, () -> Arrays.copyOf(arr, arr.length), algorithms[i]);
            System.out.printf("%s: %d msec%n", names[i], duration.toMillis());
        }
    }
}
