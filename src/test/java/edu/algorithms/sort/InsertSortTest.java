package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static edu.algorithms.complexity.ComplexityUtils.averageSortArray;
import static edu.algorithms.complexity.ComplexityUtils.calculateComplexity;


public class InsertSortTest {

    @Test
    public void testInsertSort10K() {
        Duration insertSortDuration =
                averageSortArray(10,
                        () -> RandomUtils.shuffledDistinctArray(10_000),
                        InsertSort::insertSort
                );
        System.out.printf("Duration %s ms", insertSortDuration.toMillis());
    }

    @Test
    public void complexityOfInsertSort() {
        calculateComplexity(n ->
                averageSortArray(50,
                        () -> RandomUtils.shuffledDistinctArray(n),
                        InsertSort::insertSort)
        ).ifPresentOrElse(
                complexity -> System.out.println("Complexity of Insert Sort is: " + complexity.toString()),
                () -> System.out.println("Failed to determinate complexity of algorithm")
        );
    }

}
