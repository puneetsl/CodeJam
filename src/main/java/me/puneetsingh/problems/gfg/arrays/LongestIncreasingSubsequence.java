package me.puneetsingh.problems.gfg.arrays;

import java.util.ArrayList;


public class LongestIncreasingSubsequence<K> {
    public static void main(String[] args) {
        Integer[] arr = {2,2};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.getSequenceDPNLOGN(arr));
        System.out.println(lis.getLISDP(arr));
    }

    public Integer getLISDP(Integer[] num)
    {
        int[] DP = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            DP[i] = 1;
        }
        int max =0;
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i]>num[j]&&DP[i]<DP[j]+1) {
                    DP[i] = DP[j] + 1;
                    max = max<DP[i]?DP[i]:max;
                }
            }
        }
//        for (int s: DP)
//        {
//            System.out.println(s);
//        }
        return max;
    }
    private int ceilIndex(Integer[] input, int T[], int end, int s) {
        int start = 0;
        int middle;
        int len = end;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle < len && input[T[middle]] < s && s <= input[T[middle + 1]]) {
                return middle + 1;
            } else if (input[T[middle]] < s) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public int getSequenceDPNLOGN(Integer[] input) {
        int T[] = new int[input.length];
        int R[] = new int[input.length];
        for (int i = 0; i < R.length; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[T[0]] > input[i]) { //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
            } else if (input[T[len]] < input[i]) { //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                R[T[len]] = T[len - 1];
            } else { //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len, input[i]);
                if(index>0) {
                    T[index] = i;
                    R[T[index]] = T[index - 1];
                }
            }
        }
        System.out.println();
        return len+1;
    }
}
