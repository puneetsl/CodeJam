package me.puneetsingh.basics.Lists;


import java.util.*;

public class IteratorOfIterators {

    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);one.add(2);one.add(3);one.add(4);
        ArrayList<Integer> two = new ArrayList<>();
        two.add(11);two.add(12);two.add(13);
        ArrayList<Integer> three = new ArrayList<>();
        three.add(21);three.add(22);three.add(23);three.add(24);
        three.add(25);three.add(26);three.add(27);
        lists.add(one);lists.add(two);lists.add(three);
        printColumn(lists);
    }

    private static void printColumn(List<List<Integer>> lists) {
        Iterator<List<Integer>> top = lists.iterator();
        while(top.hasNext()) {
            while (top.hasNext()) {
                List<Integer> val = top.next();
                Iterator<Integer> in = val.iterator();
                if (in.hasNext()) {
                    System.out.print(in.next() + " ");
                    in.remove();
                }
                else
                    top.remove();
            }
            top = lists.iterator();
        }
    }


}
