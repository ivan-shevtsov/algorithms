package edu.algorithms.search;

import edu.algorithms.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RedBlackTreeTest {

    @Test
    public void shouldMaintainBalancedTree() {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        int[] keys = RandomUtils.shuffledDistinctArray(100);
        Arrays.stream(keys)
                .forEach(k -> tree.put(k, k));
        String s = tree.toString();
        System.out.println(s);
    }


}