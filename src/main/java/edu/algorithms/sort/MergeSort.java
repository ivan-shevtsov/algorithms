package edu.algorithms.sort;

import edu.algorithms.utils.ArrayUtils;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSortUpDown(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        mergeSortUpDown(a, copy, 0, a.length - 1);
    }

    private static void mergeSortUpDown(int[] a, int[] copy, int from, int to) {
        if (from < to) {
            mergeSortUpDown(a, copy, from, (from + to) / 2);
            mergeSortUpDown(a, copy, (from + to) / 2 + 1, to);
            ArrayUtils.mergeInPlace(a, copy, from, (from + to) / 2 + 1, to);
        }
    }

    public static void mergeSortDownUp(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        for (int segmentLength = 2; segmentLength / 2.0 < a.length; segmentLength *= 2) {
            for (int i = 0; i + segmentLength / 2 < a.length ; i += segmentLength) {
                ArrayUtils.mergeInPlace(a, copy, i, i + segmentLength / 2, Math.min(a.length - 1, i + segmentLength - 1));
            }
        }
    }

}
