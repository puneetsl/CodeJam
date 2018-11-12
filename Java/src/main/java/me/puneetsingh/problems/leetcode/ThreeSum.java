package me.puneetsingh.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] ints = {0, 0, 0, 0};
        ThreeSum ts = new ThreeSum();
        ts.threeSum(ints);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lli = new ArrayList<>();
        HashSet<Integer> unq = new HashSet<>();
        Arrays.sort(nums);
        int r;
        int l;
        for (int i = 0; i < nums.length; i++) {
            r = nums.length - 1;
            l = i + 1;
            while (l < r) {
                int k = nums[i] + nums[l] + nums[r];
                if (k == 0) {
                    int cp = cantorPairing(cantorPairing(nums[i], nums[l]), nums[r]);
                    if (!unq.contains(cp)) {
                        lli.add(addInts(nums[i], nums[l], nums[r]));
                        unq.add(cp);
                    }
                }
                if (k < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return lli;
    }

    private int cantorPairing(int x, int y) {
        return ((x + y) * (x + y + 1)) / 2 + y;
    }

    private List<Integer> addInts(int num, int num1, int num2) {
        ArrayList<Integer> li = new ArrayList<>(3);
        li.add(num);
        li.add(num1);
        li.add(num2);
        System.out.println(num + "," + num1 + "," + num2);
        return li;
    }
}
