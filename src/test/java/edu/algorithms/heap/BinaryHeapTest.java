package edu.algorithms.heap;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    @Test
    public void shouldInsertAndReheapify() {
        BinaryHeap<Integer> integerBinaryHeap = new BinaryHeap<>(20, Integer.class);
        IntStream.range(0, 20)
                .map(index -> RandomUtils.randomInt(100))
                .boxed()
                .forEach(integerBinaryHeap::insertKey);

        Integer[] keys = integerBinaryHeap.getKeys();
        System.out.println(Arrays.toString(keys));
        for (int i = 2; i < keys.length; i++) {
            Assertions.assertTrue(keys[i / 2] > keys[i]);
        }

    }


}