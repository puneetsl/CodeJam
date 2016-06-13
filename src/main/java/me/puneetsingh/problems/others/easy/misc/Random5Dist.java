package me.puneetsingh.problems.others.easy.misc;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by pludu on 4/27/2016.
 */
public class Random5Dist {
    public static void main (String[] args) throws java.lang.Exception
    {
        int a[] = new int[7];
        Random r = new Random();
        for(int i=0;i<100000;i++)
        {
            a[getRand7(r)]++;
        }
        for(int i: a)
        {
            System.out.println(i);
        }
        HashMap<String,Integer> hs = new HashMap<>();
    }
    public static int getRand7(Random r)
    {
        int m = 5*getRand5(r)+getRand5(r);
        if(m<21) return m%7;
        else return getRand7(r);
    }
    public static int getRand5(Random r)
    {
        return r.nextInt(5);
    }
}
