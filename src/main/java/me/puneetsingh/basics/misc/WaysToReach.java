package me.puneetsingh.basics.misc;


import java.util.HashMap;

public class WaysToReach {
    static HashMap<Integer, Integer> prev = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws java.lang.Exception {
        int[] a = {1, 2, 4};
        int steps =20;
        long startTime = System.nanoTime();
        int ways = toReachM(a, steps, 0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 10000;
        System.out.println("Memoization: " + ways + " " + duration + " MS");
        startTime = System.nanoTime();
        ways = toReachNM(a, steps, 0);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000;
        System.out.println("No Memoization: " + ways + " " + duration + " MS");
        startTime = System.nanoTime();
        ways = toReachNonRecursive(a, steps);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000;
        System.out.println("Iterative: " + ways + " " + duration + " MS");

    }

    public static int toReachNonRecursive(int[] a, int x) {
        int last[] = new int[a.length];
        last[0] = 1;last[1] = 1;last[2] = 2;
        for (int i = a.length; i <= x; i++) {
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                sum = sum + last[j];
            }
            last[i % a.length] = sum;
        }
        return last[x % 3];
    }

    public static int toReachM(int[] a, int x, int c) {
        if (c == x) {
            return 1;
        }
        if (c > x) {
            return 0;
        }
        int ways = 0;
        if (prev.containsKey(c)) {
            ways = ways + prev.get(c);
        } else {
            for (int i = 0; i < a.length; i++) {
                int reach = toReachM(a, x, c + a[i]);
                ways = ways + reach;
//                System.out.println("i =" + i + " reach" + reach);

            }
        }
        prev.put(c, ways);
        return ways;
    }

    public static int toReachNM(int[] a, int x, int c) {
        if (c == x) {
            return 1;
        }
        if (c > x) {
            return 0;
        }
        int ways = 0;

        for (int i = 0; i < a.length; i++) {
            int reach = toReachNM(a, x, c + a[i]);
            ways = ways + reach;

        }
        return ways;
    }
}
