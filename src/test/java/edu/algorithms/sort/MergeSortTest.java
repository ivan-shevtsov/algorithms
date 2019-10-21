package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static edu.algorithms.complexity.ComplexityUtils.averageSortArray;
import static edu.algorithms.complexity.ComplexityUtils.calculateComplexity;

class MergeSortTest {

    @Test
    public void mergeSortUpDown() {
        int[] a = RandomUtils.shuffledDistinctArray(13);
        System.out.println(Arrays.toString(a));
        MergeSort.mergeSortUpDown(a);
        System.out.println(Arrays.toString(a));
        Assertions.assertTrue(
                IntStream.range(1, a.length)
                .noneMatch(index -> a[index] < a[index - 1])
        );
    }

    @Test
    public void detectComplexityOfUpDownMergeSort() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        MergeSort::mergeSortUpDown)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of UpDownMerge Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }

    @Test
    public void mergeSortDownUp() {
        int[] a = RandomUtils.shuffledDistinctArray(13);
        System.out.println(Arrays.toString(a));
        MergeSort.mergeSortDownUp(a);
        System.out.println(Arrays.toString(a));
        Assertions.assertTrue(
                IntStream.range(1, a.length)
                        .noneMatch(index -> a[index] < a[index - 1])
        );
    }

    @Test
    public void complexityOfDownUpMergeSort() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        MergeSort::mergeSortDownUp)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of UpDownMerge Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }


}