package edu.algorithms.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

import static edu.algorithms.utils.ArrayUtils.exchange;
import static edu.algorithms.utils.ArrayUtils.less;

public class BinaryHeap<T extends Comparable> {

    private T[] keys;
    int size = 0;

    public BinaryHeap(int size, Class<T> keyClass) {
        keys = (T[]) Array.newInstance(keyClass, size + 1);
    }

    public void insertKey(T key) {
        keys[++size] = key;
        swim(size);
    }

    /**
     * Bottom-up reheapify... check if order with parent is not violated
     * @param k index of added or increased Key
     */
    private void swim(int k) {
        while (k > 1 && less(keys[k / 2], keys[k])) {
            exchange(keys, k / 2, k);
            k = k / 2;
        }
    }

    /**
     * The weight of Element at some position was decreased - it should sink down the heap
     * @param k
     */
    private void sink(int k) {
        int minChild = minBetweenChildren(k);
        if (minChild > 0) {
            exchange(keys, minChild, k);
            sink(minChild);
        }
    }

    private int minBetweenChildren(int k) {
        if (k * 2 == size) {
            return k * 2;
        } else if (k * 2 + 1 >= size) {
            return keys[k * 2 + 1].compareTo(keys[k * 2]) > 0 ? k * 2 : k * 2 + 1;
        }
        return 0;
    }

    public T[] getKeys() {
        return Arrays.copyOf(keys, keys.length);
    }

}
