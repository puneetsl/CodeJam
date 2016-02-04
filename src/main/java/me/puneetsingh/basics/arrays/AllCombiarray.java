package me.puneetsingh.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class AllCombiarray {
    private List<List<Integer>> getAllCombi(Integer[] arr)
    {
        boolean[] bb = new boolean[arr.length];
        List<List<Integer>> alphaList = new ArrayList<>();

        for (int i = 0; i < Math.pow(2,arr.length); i++) {

            List<Integer> lst = getCombi(bb, arr);
            binaryCounter(bb);
            alphaList.add(lst);
        }
        return alphaList;
    }
    private static void binaryCounter(boolean[] counter) {

        int curr = counter.length-1;

        while(counter[curr]==true&&curr!=0)
        {
            counter[curr] = false;
            curr--;
        }
        counter[curr] = true;
    }

    private List<Integer> getCombi(boolean[] bb, Integer[] arr) {
        List<Integer> lst = new ArrayList<>();
        int i=0;
        for (boolean b:bb){
            if(b)
                lst.add(arr[i]);
            i++;
        }
        return lst;
    }

    private static void print(boolean[] bb) {
        for (boolean b:bb){
            System.out.print(b+" ");
        }
        System.out.println();
    }
}
