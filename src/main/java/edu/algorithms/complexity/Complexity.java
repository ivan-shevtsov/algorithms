package edu.algorithms.complexity;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Complexity {

    public static Duration executeAndMeasure(Runnable r) {
        Instant begin = Instant.now();
        r.run();
        return Duration.between(begin, Instant.now());
    }

    public static Duration averageSortArray(int count, Supplier<int[]> sourceArraySupplier, Consumer<int[]> sorter) {
        Duration totalDuration = Duration.ZERO;
        for (int i = 0; i < count; i++) {
            int[] a = sourceArraySupplier.get();
            Duration cycleDuration = executeAndMeasure(() -> sorter.accept(a));
            System.out.printf("%d - %dms%n", i, cycleDuration.toMillis());
            totalDuration = totalDuration.plus(cycleDuration);
        }
        return totalDuration.dividedBy(count);
    }

}
