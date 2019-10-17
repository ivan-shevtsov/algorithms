package edu.algorithms.sort;

import edu.algorithms.utils.CompareAlgorithms;
import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class CompareSortTest {
    @Test
    public void testInsertSort10K() {
        CompareAlgorithms.compare(100, () -> RandomUtils.shuffledDistinctArray(10_000),
                InsertSort::insertSort, SelectSort::selectSort);
    }

    @Test
    public void testWorstInsertSort10K() {
        CompareAlgorithms.compare(100, () -> RandomUtils.distinctReverseSortedArray(10_000),
                InsertSort::insertSort, SelectSort::selectSort);
    }

    @Test
    public void testBestInsertSort10K() {
        CompareAlgorithms.compare(100, () -> RandomUtils.distinctSortedArray(10_000),
                InsertSort::insertSort, SelectSort::selectSort);
    }
}
