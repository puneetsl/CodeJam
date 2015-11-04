package me.puneetsingh.basics.sort;

import me.puneetsingh.basics.misc.Shuffle;
import me.puneetsingh.utils.SortHelper;

import java.util.Arrays;

public class MergeSort {
    private static int comparisons = 0;

    public static int getComparisons() {
        return comparisons;
    }

    public static void sort(Comparable[] a) {
        comparisons = 0;
        merge(a, Arrays.copyOf(a, a.length), 0, a.length - 1);
    }

    private static void merge(Comparable[] a, Comparable[] c, int start, int end) {
        int mid = start + (end - start) / 2;
        if (end - start <= 0)
            return;
        merge(a, c, start, mid);
        merge(a, c, mid + 1, end);
        sortedmerge(a, c, start, mid, end);
    }

    private static void sortedmerge(Comparable[] a, Comparable[] c, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int i_max = mid + 1;
        int j_max = end + 1;
        int k = start;
        while (i < i_max && j < j_max) {
            comparisons++;
            if (SortHelper.less(a[i], a[j])) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i < i_max) {
            c[k++] = a[i++];
            comparisons++;
        }
        while (j < j_max) {
            c[k++] = a[j++];
            comparisons++;
        }
        i = start;
        for (k = start; k < j_max; k++) {
            a[i++] = c[k];
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = i + 1;
        }
        Shuffle.randomize(a);
        System.out.println("Unsorted:");
        for (int x : a) {
            System.out.println(x);
        }
        System.out.println("Sorted:");
        long startTime = System.nanoTime();
        MergeSort.sort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        for (int x : a) {
            System.out.println("_" + x);
        }
        System.out.println("Comparisons:" + getComparisons());
        System.out.println("Time took:" + duration / 1000000);
    }
}
