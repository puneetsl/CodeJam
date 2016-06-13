package me.puneetsingh.problems.gfg.arrays;

import java.util.ArrayList;


public class LongestIncreasingSubsequence<K> {
    public static void main(String[] args) {
        Integer[] arr = {0,1,2,3,4,5,1,3,8};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        lis.getSequenceDPNLOGN(arr);
    }

    public Comparable<K>[] getSequenceDPN2(Comparable<K>[] arr) {
        ArrayList<Comparable<K>> seqList = new ArrayList<Comparable<K>>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
            }
        }
        return null;
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
                T[index] = i;
                R[T[index]] = T[index - 1];
            }
        }
        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        int index = T[len];
        while (index != -1) {
            System.out.print(input[index] + " ");
            index = R[index];
        }
        System.out.println();
        return len + 1;
    }
}
