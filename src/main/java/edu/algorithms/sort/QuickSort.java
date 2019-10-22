package edu.algorithms.sort;

import edu.algorithms.utils.ArrayUtils;
import edu.algorithms.utils.RandomUtils;

public class QuickSort {

    public static void quickSort(int[] a) {
        RandomUtils.shuffleArray(Math.min(100, a.length), a);
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int partition = partition(a, lo, hi);
            quickSort(a, lo, partition);
            quickSort(a, partition + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int left = lo + 1;
        int right = hi;

        while (true) {
            while (left <= right && ArrayUtils.less(a[left], a[lo])) {
                left++;
            }
            while (right >= left && ArrayUtils.less(a[lo], a[right])) {
                right --;
            }

            if (left > right) {
                break;
            }

            ArrayUtils.exchange(a, left, right);
        }

        ArrayUtils.exchange(a, lo, left - 1);
        return left - 1;
    }

}
