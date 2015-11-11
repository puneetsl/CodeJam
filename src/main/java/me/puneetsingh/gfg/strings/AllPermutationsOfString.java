package me.puneetsingh.gfg.strings;

import java.util.*;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class AllPermutationsOfString {

    public static void permutationRecursive(String str) {
        permutationRecursive("", str);
    }
    private static void permutationRecursive(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutationRecursive(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
    public static void permutationIterative(String str) {
        LinkedList<String> v = new LinkedList<String>();
        if (str.length() <= 1) {
            System.out.println(str);
            return;
        }
        v.add(String.valueOf(str.charAt(0)));
        int w;
        for (int p = 1; p < str.length(); p++) {
            w = v.size();
            for (int j = 0; j < w; j++) {
                String t = v.removeFirst();//Kind of BFS Tree traversal
                for (int i = 0; i < t.length() + 1; i++) {
                    v.addLast(t.substring(0, i) + str.charAt(p) + t.substring(i, t.length()));
                }
            }
        }
        for (String s : v) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        //permutationRecursive("abcde");
        permutationIterative("abcd");

    }

}
