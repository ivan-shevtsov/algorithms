package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static edu.algorithms.sort.HeapSort.heapSort;

class HeapSortTest {


    @Test
    public void validateAscedancySortedByHeapAlg() {
        int[] a = RandomUtils.shuffledDistinctArray(10);
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));

        Assertions.assertTrue(
                IntStream.range(1, a.length)
                        .noneMatch(index -> a[index] < a[index - 1])
        );
    }

}