package me.puneetsingh.runners;

import me.puneetsingh.utils.commons.cache.SortedMapCountSet;

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
        System.out.println(smcs.size());

        for (Object s : smcs) {
            System.out.println(s);
        }
        System.out.println();
        smcs.remove("D");
        for (Object s : smcs) {
            System.out.println(s);
        }
    }
}
