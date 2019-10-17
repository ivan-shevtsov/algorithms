package edu.algorithms.sort;

import static edu.algorithms.utils.ArrayUtils.exchange;

public class SelectSort {

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minValue = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minValue]) {
                    minValue = j;
                }
            }
            exchange(a, i, minValue);
        }
    }
}
