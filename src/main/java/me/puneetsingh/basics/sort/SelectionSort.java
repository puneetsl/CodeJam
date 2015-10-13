package me.puneetsingh.basics.sort;


import me.puneetsingh.utils.SortHelper;


public class SelectionSort {
    public static int getComparisons() {
        return comparisons;
    }

    private static int comparisons =0;
    public static void sort(Comparable[] a) {
        int minIndex;
        comparisons=0;
        try {
            for (int i = 0; i < a.length; i++) {
                minIndex = i;
                for (int j = i + 1; j < a.length; j++) {
                    comparisons++;
                    if (SortHelper.less(a[j], a[minIndex])) {
                        minIndex = j;
                    }
                }
                SortHelper.swap(a, minIndex, i);
            }
        } catch (NullPointerException npe) {
            System.err.println("This input is invalid");
        }
    }

    public static void main(String[] args) {
        Integer a[] = {5,6,3,4,1,7,15,26,87,17,10,98,76};
        System.out.println("Unsorted:");
        for (int x : a) {
            System.out.println(x);
        }
        System.out.println("Sorted:");
        SelectionSort.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
        System.out.println("Total comparisons: "+getComparisons());
        Integer[] b = {98,87,76,26,17,15,10,7,6,5,4,3,1};
        SelectionSort.sort(b);
        System.out.println("Worst case comparisons: " + SelectionSort.getComparisons());
    }
}
