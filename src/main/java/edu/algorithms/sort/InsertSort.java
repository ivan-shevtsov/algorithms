package edu.algorithms.sort;

import static edu.algorithms.utils.ArrayUtils.exchange;
import static edu.algorithms.utils.ArrayUtils.less;

public class InsertSort {

    public static void insertSort(int[] a) {
        for (int i =  1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
        }
    }

}
