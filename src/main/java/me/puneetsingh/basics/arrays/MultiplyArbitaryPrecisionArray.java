package me.puneetsingh.basics.arrays;

import java.util.*;

public class MultiplyArbitaryPrecisionArray {
    public static void main(String[] args) {
        Integer[] b = {2, 5};
        Integer[] a = {2, 5};
        int[] m = getMultiplication(a, b);
        for (int i = m.length - 1; i >= 0; i--) {
            System.out.print(m[i]);
        }

    }

    private static int[] getMultiplication(Integer[] a, Integer[] b) {
        int[] m = new int[a.length + b.length];
        int carry, tem, r;
        a = reverse(a);
        b = reverse(b);
        Integer[] l = a.length > b.length ? a : b;
        Integer[] s = a.length <= b.length ? a : b;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < l.length; j++) {
                tem = s[i] * l[j];
                r = tem + m[i + j];
                m[i + j] = r % 10;
                carry = r / 10;
                m[i + j + 1] += carry;
            }
        }
        return m;
    }

    public static Integer[] reverse(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray(new Integer[arr.length]);
    }
}
