package edu.algorithms.utils;

import java.util.Comparator;

public class ArrayUtils {

    public static <T> void exchange(T[] massive, int index1, int index2) {
        T a = massive[index1];
        massive[index1] = massive[index2];
        massive[index2] = a;
    }

    public static void exchange(int[] massive, int index1, int index2) {
        int a = massive[index1];
        massive[index1] = massive[index2];
        massive[index2] = a;
    }

    public static <T extends Comparable> T min(T[] a) {
        T min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
        }
        return min;
    }

    public static <T extends Comparable> T max(T[] a) {
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return max;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static <T extends Comparable> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static void mergeInPlace(int[] a, int[] buffer, int lo, int mi, int hi) {
        copy(a, buffer, lo, hi);
        int left = lo;
        int right = mi;
        for (int i = lo; i <= hi; i++) {
            if (left >= mi) {
                a[i] = buffer[right++];
            } else if (right > hi) {
                a[i] = buffer[left++];
            } else if (less(buffer[left], buffer[right])) {
                a[i] = buffer[left++];
            } else {
                a[i] = buffer[right++];
            }
        }
    }

    public static void copy(int[] a, int[] buffer, int from, int to) {
        for (int i = from; i <= to; i++) {
            buffer[i] = a[i];
        }
    }

}
