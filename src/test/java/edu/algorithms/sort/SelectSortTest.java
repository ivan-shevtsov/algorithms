package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static edu.algorithms.complexity.ComplexityUtils.averageSortArray;
import static edu.algorithms.complexity.ComplexityUtils.calculateComplexity;
import static edu.algorithms.sort.SelectSort.selectSort;

class SelectSortTest {

    @Test
    public void shouldSortAscedancy() {
        int[] a = RandomUtils.shuffledDistinctArray(100);
        selectSort(a);
        for (int i = 0; i < a.length - 1; i++) {
            Assertions.assertTrue(a[i+1] > a[i]);
        }
    }

    @Test
    public void complexityOfSelectSortOnDistinctArray() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        SelectSort::selectSort)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of Insert Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }


}