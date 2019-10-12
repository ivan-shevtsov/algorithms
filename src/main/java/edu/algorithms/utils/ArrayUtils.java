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

    public static boolean less(int a, int b) {
        return a < b;
    }

}
