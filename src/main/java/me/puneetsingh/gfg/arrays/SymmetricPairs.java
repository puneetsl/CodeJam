package me.puneetsingh.gfg.arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Question: http://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/
 */
public class SymmetricPairs {
    private static final Integer[][] arr = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};

    public static void main(String[] args) {
        ArrayList<Integer[]> list = getSymmetricPairs(arr);
        if (list == null) {
            System.out.println("Something went wrong, take a look at your input");
        } else
            for (Integer[] i : list) {
                System.out.println(i[0] + "," + i[1]);
            }
    }

    private static ArrayList<Integer[]> getSymmetricPairs(Integer[][] arr) {
        HashMap<Integer, Integer> hma = new HashMap<Integer, Integer>();
        ArrayList<Integer[]> out = new ArrayList<Integer[]>();
        if (arr == null || arr.length == 0)
            return null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 2) {
                return null;
            }
            if (hma.containsKey(arr[i][1])) {
                if (arr[hma.get(arr[i][1])][0].equals(arr[i][1])) {
                    out.add(arr[hma.get(arr[i][1])]);
                }
            }
            hma.put(arr[i][0], i);
        }
        return out;
    }
}
