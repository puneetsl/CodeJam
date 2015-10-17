package me.puneetsingh.utils;


import java.util.ArrayList;

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

    public static <T extends Comparable> ArrayList<T> merge(T[] a, T[] b)
    {
        int i=0, j=0;
        ArrayList<T> c = new ArrayList<T>(a.length+b.length);
        while(i<a.length&&j<b.length)
        {
            if(less(a[i],b[j]))
            {
                c.add(a[i++]);
            }
            else
            {
                c.add(b[j++]);
            }

        }
        while(i<a.length) c.add(a[i++]);
        while(j<b.length) c.add(b[j++]);
        return c;
    }

}
