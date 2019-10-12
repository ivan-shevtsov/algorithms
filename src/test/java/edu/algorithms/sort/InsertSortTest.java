package edu.algorithms.sort;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static edu.algorithms.complexity.Complexity.averageSortArray;

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

}
