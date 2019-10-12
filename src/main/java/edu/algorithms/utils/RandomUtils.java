package edu.algorithms.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

import static edu.algorithms.utils.ArrayUtils.exchange;

public class RandomUtils {

    static SecureRandom random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] distinctSortedArray(int size) {
        return IntStream
                .range(0, size)
                .toArray();
    }

    public static int randomInt(int maxExclusive){
        return Math.abs(random.nextInt()) % maxExclusive;
    }

    public static int[] shuffledDistinctArray(int size) {
        return shuffledDistinctArray(size, size);
    }

    public static int[] shuffledDistinctArray(int size, int shuffleCount) {
        int[] a = distinctSortedArray(size);
        for (int i = 0; i < shuffleCount; i++) {
            exchange(a, randomInt(size), randomInt(size));
        }
        return a;
    }
}
