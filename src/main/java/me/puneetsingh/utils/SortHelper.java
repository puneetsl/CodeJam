package me.puneetsingh.utils;



public class SortHelper {

    public static void swap(Comparable[] comparables, int i, int j)
    {
        Comparable swp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = swp;
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b)<0;
    }
}
