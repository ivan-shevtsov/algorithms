package edu.algorithms.complexity;

import edu.algorithms.utils.ArrayUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ComplexityUtils {

    public static final int COMPLEXITY_ANALYZE_STEP = 10_000;
    public static final double COMPLEXITY_DELTA = 5.0;

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
            totalDuration = totalDuration.plus(cycleDuration);
        }
        return totalDuration.dividedBy(count);
    }

    public static Optional<Complexity> calculateComplexity(Function<Integer, Duration> avarageExecution) {
        Duration[] durations = new Duration[5];
        IntStream.rangeClosed(1, 5)
                .parallel()
                .forEach(index -> {
                    int N = index * COMPLEXITY_ANALYZE_STEP;
                    durations[index - 1] = avarageExecution.apply(N);
                });

        return Stream.of(ComplexityLevel.values())
                .map(level -> complexityWithCooficient(level, durations))
                .filter(Objects::nonNull)
                .findAny();
    }

    private static Complexity complexityWithCooficient(ComplexityLevel complexityLevel, Duration[] durations) {
        Double[] kooficients = new Double[durations.length];
        for (int i = 1; i <= durations.length; i++) {
            int n = i * COMPLEXITY_ANALYZE_STEP;
            kooficients[i - 1] = ((double) durations[i - 1].toNanos()) / complexityLevel.baseFunction.apply(n);
        }

        System.out.println(complexityLevel.name() + ": " + Arrays.toString(kooficients));

        double minKoof = ArrayUtils.min(kooficients);
        double maxKoof = ArrayUtils.max(kooficients);

        if (Math.abs(maxKoof - minKoof) < COMPLEXITY_DELTA) {
            return new Complexity(complexityLevel, (maxKoof + minKoof) / 2.0);
        }

        return null;
    }


}
