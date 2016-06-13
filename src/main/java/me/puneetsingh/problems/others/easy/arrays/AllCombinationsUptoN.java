package me.puneetsingh.problems.others.easy.arrays;

import java.util.*;

public class AllCombinationsUptoN {


    private static void printVals(Integer[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            printVals(arr,i,j, new LinkedList<Integer>());//LinkedList as Stack
        }

    }
    private static void printVals(Integer[] arr, int i, int k, LinkedList<Integer> s) {
        s.add(arr[k]);
        if(s.size()==i) {
            System.out.println(Arrays.toString(s.toArray()));
            s.removeLast();
            return;
        }
        for (int j = k+1; j < arr.length; j++) {
            printVals(arr,i,j, s);

        }
        s.removeLast();
    }
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        printVals(arr,6);
    }
}
