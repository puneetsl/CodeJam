package me.puneetsingh.problems.eopi;

/*
    Given two positive integers x and y, how would you compute x/y if the only operators you can use are addition, subtraction, and shifting?
 */

public class DivideWithoutOperator {
    static int multiply(int a, int b) {
        int out = 0;
        for (int i = 0; i < b; i++) {
            out += a;
        }
        return out;
    }

    static String divide(int n, int d, int p) {
        StringBuilder out = new StringBuilder();
        int bp = 0;
        int ap = 0;
        while (n >= d) {
            n = n - d;
            bp++;
        }
        out.append(String.valueOf(bp));
        if (p > 0)
            out.append(".");
        for (int i = 0; i < p; i++) {
            n = multiply(n, 10);
            while (n > d) {
                n = n - d;
                ap++;
            }
            out.append(String.valueOf(ap));
            ap = 0;
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(divide(22, 12, 15));//0.0107237499
        // System.out.println(divide(1000, 3, 3));
    }
}
