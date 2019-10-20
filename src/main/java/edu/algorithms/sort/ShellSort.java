package edu.algorithms.sort;

import edu.algorithms.utils.ArrayUtils;

public class ShellSort {

    public static void shellSort(int[] a) {
//        System.out.println(Arrays.toString(a));
        for (int h = shellSegment(a); h >= 1; h = h / 3) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && ArrayUtils.less(a[j], a[j - h]); j -= h) {
                    ArrayUtils.exchange(a, j, j - h);
                }
            }
//            System.out.print("h[" + h + "] ");
//            System.out.println(Arrays.toString(a));
        }
    }

    private static int shellSegment(int[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = h * 3 + 1;
        }
        return h;
    }

}
