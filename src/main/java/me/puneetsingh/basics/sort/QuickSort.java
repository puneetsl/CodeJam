package me.puneetsingh.basics.sort;

import me.puneetsingh.utils.SortHelper;

public class QuickSort {
    private static int comparisons = 0;

    public static int getComparisons() {
        return comparisons;
    }

    public static void sort(Comparable[] a) {
        comparisons = 0;
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        int i = low, j = high;
        int pivIndex = low + (high - low) / 2;
        if (low >= high)
            return;
        while (i <= j) {
            //System.out.println(i+":"+j+":"+pivIndex);
            while (SortHelper.less(a[i], a[pivIndex])) {
                i++;
            }
            while (SortHelper.less(a[pivIndex], a[j])) {
                j--;
            }
            if (i <= j) {
                SortHelper.swap(a, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            sort(a, low, j);//left
        if (i < high)
            sort(a, i, high);//right
    }

    public static void main(String[] args) {
        Integer a[] = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12, 20};
        System.out.println("Unsorted:");
        for (int x : a) {
            System.out.println(x);
        }
        System.out.println("Sorted:");
        QuickSort.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
        System.out.println("Total comparisons: " + getComparisons());
//        Integer[] b = {98,87,76,26,17,15,10,7,6,5,4,3,1};
//        ShellSort.sort(b);
//        System.out.println("Worst case comparisons: " + ShellSort.getComparisons());
    }
}
