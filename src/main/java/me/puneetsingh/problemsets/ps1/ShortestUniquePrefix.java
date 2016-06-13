package me.puneetsingh.problemsets.ps1;


import me.puneetsingh.utils.commons.trees.Tries;
import me.puneetsingh.utils.Strings;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        String arr2[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks", "dog"};
        printSUP(arr);
        System.out.println();
        printSUP(arr2);
    }

    private static void printSUP(String[] arr) {
        Tries t = new Tries();
        for (String s: arr)
        {
            t.insert(s);
        }
        for (String s: arr)
        {

            printSUPString(s,t);
        }
    }

    private static void printSUPString(String s, Tries node) {
        Character[] sArr = Strings.toCharacterArray(s);
        Tries t=node.root;
        int lastDivIndex=0;
        int index=0;
        for (Character c: sArr)
        {
            index++;
            if(t.nodes.containsKey(c)&&t.nodes.size()>1)
            {
                lastDivIndex = index;
                t= t.nodes.get(c);
            }
            else
            {
                t= t.nodes.get(c);

            }
        }
        System.out.println(s.substring(0,lastDivIndex));

    }
}
