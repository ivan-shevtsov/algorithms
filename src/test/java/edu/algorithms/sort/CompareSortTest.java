package edu.algorithms.sort;

import edu.algorithms.utils.CompareAlgorithms;
import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class CompareSortTest {

    public static final int TEST_ARRAY_LENGTH = 50_000;
    public static final int REPEAT_COUNT = 10;

    @Test
    public void testInsertSort10K() {
        System.out.println("--- shuffledDistinctArray");
        CompareAlgorithms.compare(REPEAT_COUNT, () -> RandomUtils.shuffledDistinctArray(TEST_ARRAY_LENGTH),
                new String[] {
                        "Insert Sort",
                        "Select Sort",
                        "Shell Sort",
                        "Up-Down Merge",
                        "Down-Up Merge",
                        "Quick Sort",
                        "Heap Sort"
                },
                InsertSort::insertSort,
                SelectSort::selectSort,
                ShellSort::shellSort,
                MergeSort::mergeSortUpDown,
                MergeSort::mergeSortDownUp,
                QuickSort::quickSort,
                HeapSort::heapSort);
    }

    @Test
    public void testWorstInsertSort10K() {
        System.out.println("--- distinctReverseSortedArray");
        CompareAlgorithms.compare(REPEAT_COUNT, () -> RandomUtils.distinctReverseSortedArray(TEST_ARRAY_LENGTH),
                new String[] {
                        "Insert Sort",
                        "Select Sort",
                        "Shell Sort",
                        "Up-Down Merge",
                        "Down-Up Merge",
                        "Quick Sort",
                        "Heap Sort"
                },
                InsertSort::insertSort,
                SelectSort::selectSort,
                ShellSort::shellSort,
                MergeSort::mergeSortUpDown,
                MergeSort::mergeSortDownUp,
                QuickSort::quickSort,
                HeapSort::heapSort);
    }

    @Test
    public void testBestInsertSort10K() {
        System.out.println("--- distinctSortedArray");
        CompareAlgorithms.compare(REPEAT_COUNT, () -> RandomUtils.distinctSortedArray(TEST_ARRAY_LENGTH),
                new String[] {
                        "Insert Sort",
                        "Select Sort",
                        "Shell Sort",
                        "Up-Down Merge",
                        "Down-Up Merge",
                        "Quick Sort",
                        "Heap Sort"
                },
                InsertSort::insertSort,
                SelectSort::selectSort,
                ShellSort::shellSort,
                MergeSort::mergeSortUpDown,
                MergeSort::mergeSortDownUp,
                QuickSort::quickSort,
                HeapSort::heapSort);
    }
}
