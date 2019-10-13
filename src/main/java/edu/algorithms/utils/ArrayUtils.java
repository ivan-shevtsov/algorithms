package edu.algorithms.utils;

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

}