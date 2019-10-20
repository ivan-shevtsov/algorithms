package edu.algorithms.sort;

import edu.algorithms.complexity.ComplexityUtils;
import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static edu.algorithms.complexity.ComplexityUtils.averageSortArray;
import static edu.algorithms.complexity.ComplexityUtils.calculateComplexity;
import static edu.algorithms.complexity.ComplexityUtils.executeAndMeasure;
import static edu.algorithms.sort.ShellSort.shellSort;

class ShellSortTest {


    @Test
    public void should_sort_array_with_shell_sort() {
        int[] a = RandomUtils.shuffledDistinctArray(15);
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void duration_of_shell_sort() {
        int[] a = RandomUtils.shuffledDistinctArray(1_000_000);
        Duration duration = executeAndMeasure(() -> shellSort(a));
        System.out.println(duration.toMillis() + "msec");
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void shell_sort_complexity() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        ShellSort::shellSort)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of Shell Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }

}