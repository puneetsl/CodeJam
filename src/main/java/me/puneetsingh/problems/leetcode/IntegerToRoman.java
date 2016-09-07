package me.puneetsingh.problems.leetcode;

import java.util.HashMap;

public class IntegerToRoman {
    private HashMap<Integer, String> base = new HashMap<>(15);

    public String intToRoman(int num) {
        return itor(num);
    }

    private String itor(int num) {
        /*
         Unoptimized Solution
         */
        if (base.size() == 0)
            fill(base);
        if (base.containsKey(num))
            return base.get(num);
        if (num == 0) return "";
        else {
            int r = closestRepeatable(num);
            int u = closestUpper(num);
            int l = closestLower(num);
            StringBuilder s = new StringBuilder("");
            if (u - r <= num)
                return base.get(r) + base.get(u) + itor(num % r);
            else {
                while (num - l > 0) {
                    s.append(base.get(l));
                    num = num - l;
                }
                return s.append(itor(num)).toString();
            }
        }
    }

    private int closestLower(int num) {
        if (num > 1000) return 1000;
        if (num > 500) return 500;
        if (num > 100) return 100;
        if (num > 50) return 50;
        if (num > 10) return 10;
        if (num > 5) return 5;
        if (num > 1) return 1;
        return 0;
    }

    private int closestUpper(int num) {
        if (num > 1000) return 5999;
        if (num > 500) return 1000;
        if (num > 100) return 500;
        if (num > 50) return 100;
        if (num > 10) return 50;
        if (num > 5) return 10;
        if (num > 1) return 5;
        return 0;
    }

    private int closestRepeatable(int num) {
        int n = (int) Math.log10(num);
        return (int) Math.pow(10, n);
    }

    private void fill(HashMap<Integer, String> b) {
        b.put(1, "I");
        b.put(5, "V");
        b.put(10, "X");
        b.put(50, "L");
        b.put(100, "C");
        b.put(500, "D");
        b.put(1000, "M");
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(4));
    }
}
