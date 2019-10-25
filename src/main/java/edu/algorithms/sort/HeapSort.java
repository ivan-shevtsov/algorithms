package edu.algorithms.sort;

import edu.algorithms.utils.ArrayUtils;

public class HeapSort {

    public static void heapSort(int[] a) {

        for (int i = a.length / 2; i >= 0; i--) {
            sink(a, i, a.length);
        }

        int n = a.length - 1;
        while (n > 0) {
            ArrayUtils.exchange(a, 0, n);
            sink(a, 0, n--);
        }
    }

    private static void sink(int[] a, int i, int n) {
        int maxChild = maxChildForParent(a, i, n);
        if (maxChild > i && a[maxChild] > a[i]) {
            ArrayUtils.exchange(a, i, maxChild);
            sink(a, maxChild, n);
        }
    }

    private static int maxChildForParent(int[] a, int i, int n) {
        int first = (i << 1) + 1;
        if (first >= n) {
            return -1;
        }
        if (first + 1 >= n) {
            return first;
        }
        return a[first] > a[first + 1] ? first : first + 1;
    }

}
