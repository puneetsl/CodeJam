package me.puneetsingh.basics.misc;



import me.puneetsingh.utils.SortHelper;

import java.security.SecureRandom;
import java.util.Random;

public class Shuffle {
    public static void randomize(Comparable[] a)
    {
        SecureRandom r = new SecureRandom();
        try {
            Thread.sleep(r.nextInt(1000));
            //Adding one more layer of randomness to protect time based generated random number
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        for (int i = 0; i < a.length; i++) {
            int x = r.nextInt(a.length-1);
            SortHelper.swap(a,i,x);
        }
    }
    public static void main(String[] args) {
        Integer a[] = {98,87,76,26,17,15,10,7,6,5,4,3,1};
        System.out.println("Ordered:");
        for (int x: a)
        {
            System.out.println(x);
        }
        System.out.println("Shuffled:");
        Shuffle.randomize(a);
        for (int x: a)
        {
            System.out.println(x);
        }
    }
}
