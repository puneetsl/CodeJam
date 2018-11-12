package me.puneetsingh.problems.others.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllCombiarray {
    private List<List<Integer>> getAllCombi(int[] arr)
    {
        boolean[] bb = new boolean[arr.length];
        List<List<Integer>> alphaList = new ArrayList<>();

        for (int i = 0; i < Math.pow(2,arr.length); i++) {

            List<Integer> lst = getCombi(bb, arr);
            binaryCounter(bb);
            Collections.sort(lst);
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

    private List<Integer> getCombi(boolean[] bb, int[] arr) {
        List<Integer> lst = new ArrayList<>();
        int i=0;
        for (boolean b:bb){
            if(b)
                lst.add(arr[i]);
            i++;
        }
        return lst;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        AllCombiarray aca = new AllCombiarray();
        List<List<Integer>> ll = aca.getAllCombi(arr);
        for (List<Integer> l: ll) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
