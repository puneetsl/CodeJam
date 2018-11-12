package me.puneetsingh.problems.gfg.misc;

import java.util.Arrays;

public class MeetInTheMiddle {

    public int[] getSetWithMaxSum(int[] set, int S)
    {
        Arrays.sort(set);
        int i = binarySearch(set,S,0,set.length);
        if(set[i] == S) {
            int[] r= {S};
            return r;
        }
        else
        {
            int[] r= {S};
            return r;
        }

    }
    private int binarySearch(int[] sortedArray, Integer target, int start, int end) {
        if (start > end)
            return start;
        int mid = (start + end) / 2;
        int c = target.compareTo(sortedArray[mid]);
        return (c == 0) ? mid : (c < 0) ?
                binarySearch(sortedArray, target, start, mid - 1) :
                binarySearch(sortedArray, target, mid + 1, end);
    }
}
