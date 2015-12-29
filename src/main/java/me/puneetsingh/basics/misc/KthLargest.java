package me.puneetsingh.basics.misc;


public class KthLargest {
    public static Integer getKMax(Integer[] vals, Integer k)
    {
        k = k-1;
        if(k>=vals.length) return -1;
        return getKMax(vals, k, 0, vals.length-1);
    }
    public static Integer getKMax(Integer[] a, Integer k, int min, int max)
    {
        int pivot = min+ (max-min)/2;
        int i=min, j=max;
        if(min>=max)
            return -1;
        while (i <= j) {
            while (less(a[i], a[pivot])) {
                i++;
            }
            while (less(a[pivot], a[j])) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        if (i > k)
            getKMax(a, k, min, j);//left
        if (j < k)
            getKMax(a, k, i, max);//right
        return a[k];
    }
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void swap(Comparable[] comparables, int i, int j) {
        Comparable swp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = swp;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Integer[] vals = {10,16,12,14,13,9,18,17,15};
        System.out.println(getKMax(vals, 3));
    }
}
