package me.puneetsingh.Runners;

import me.puneetsingh.utils.RedBlack;

public class RedBlackRun {
    public static void main(String[] args) {
        Integer [] arr = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        RedBlack<Integer,Integer> rb = new RedBlack<Integer, Integer>();
        for (Integer i: arr)
        {
            rb.put(i,i);
        }

        System.out.println(rb.height());
    }
}
