package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static edu.algorithms.complexity.ComplexityUtils.averageSortArray;
import static edu.algorithms.complexity.ComplexityUtils.calculateComplexity;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] a = RandomUtils.shuffledDistinctArray(13);
        System.out.println(Arrays.toString(a));
        QuickSort.quickSort(a);
        System.out.println(Arrays.toString(a));
        Assertions.assertTrue(
                IntStream.range(1, a.length)
                        .noneMatch(index -> a[index] < a[index - 1])
        );
    }

    @Test
    public void complexityOfQuickSortOnDistinctArray() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        QuickSort::quickSort)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of Quick Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }

}