package me.puneetsingh.websites.hr.maths;

import java.math.BigInteger;

/**
 * Created by pludu on 8/18/2015.
 */
public class BigFactorial {
    public static void main(String[] args) {
        System.out.println(getBigFactorial(100).toString());
    }

    private static BigInteger getBigFactorial(int i) {
        BigInteger bi =BigInteger.valueOf(1);
        for (int j = 0; j < i; j++) {
            bi = bi.multiply(BigInteger.valueOf(j+1));
        }
        return bi;
    }
}
