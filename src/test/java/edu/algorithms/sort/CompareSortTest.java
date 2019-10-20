package edu.algorithms.sort;

import edu.algorithms.utils.CompareAlgorithms;
import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class CompareSortTest {

    @Test
    public void testInsertSort10K() {
        System.out.println("shuffledDistinctArray");
        CompareAlgorithms.compare(50, () -> RandomUtils.shuffledDistinctArray(10_000),
                new String[] {"Insert Sort", "Select Sort", "Shell Sort"},
                InsertSort::insertSort, SelectSort::selectSort, ShellSort::shellSort);
    }

    @Test
    public void testWorstInsertSort10K() {
        System.out.println("distinctReverseSortedArray");
        CompareAlgorithms.compare(50, () -> RandomUtils.distinctReverseSortedArray(10_000),
                new String[] {"Insert Sort", "Select Sort", "Shell Sort"},
                InsertSort::insertSort, SelectSort::selectSort, ShellSort::shellSort);
    }

    @Test
    public void testBestInsertSort10K() {
        System.out.println("distinctSortedArray");
        CompareAlgorithms.compare(50, () -> RandomUtils.distinctSortedArray(10_000),
                new String[] {"Insert Sort", "Select Sort", "Shell Sort"},
                InsertSort::insertSort, SelectSort::selectSort, ShellSort::shellSort);
    }
}
