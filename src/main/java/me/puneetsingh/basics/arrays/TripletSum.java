package me.puneetsingh.basics.arrays;


import java.util.Arrays;

public class TripletSum {

    public static void getTriplet(int[] a, int requiredSum)
    {
        Arrays.sort(a);
        int hi;
        int lo;
        for(int i=0; i < a.length-2; i++)
        {
            lo = i+1;
            hi = a.length-1;
            while(lo<hi) {
                int actualSum = a[i] + a[hi] + a[lo];
                int diff = requiredSum-actualSum;
                if (diff > 0)
                    lo++;
                else if(diff<0)
                    hi--;
                else {
                    System.out.println(a[i] + ":" + a[lo] + ":" + a[hi]+" $ "+actualSum);
                    lo++;
                    hi--;
                }
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] a = {12, 3, 4, 1, 6, 9};
        int [] array = {0,3,4,1,6,2,8,5};
        getTriplet(a,24);
        getTriplet(array,8);
    }
}
