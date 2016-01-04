package me.puneetsingh.Runners;


import me.puneetsingh.commons.cache.SortedMapCountSet;

import java.util.Iterator;

public class SortedSetCountRun {


    public static void main(String[] args) {
        SortedMapCountSet<String> smcs = new SortedMapCountSet<>();
        smcs.add("A");
        smcs.add("A");
        smcs.add("B");
        smcs.add("C");
        smcs.add("D");
        smcs.add("C");
        smcs.add("D");
        smcs.add("C");
        for (Object s : smcs) {
            System.out.println(s);
        }
    }
}
