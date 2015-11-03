package me.puneetsingh.ctci.chapter1;

import me.puneetsingh.basics.sort.QuickSort;
import me.puneetsingh.utils.Strings;

import java.util.BitSet;

public class Q1_1 {
    //if a string has all unique chars, without using any additional DS
    // O(n^2)
    private static boolean hasAllUnique(String s)
    {
        for(int i=0; i< s.length()-1; i++)
        {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j))
                    return false;
            }
        }
        return true;
    }
    //if a string has all unique chars
    //Assuming only 256 chars are possible
    // O(n)
    private static boolean hasAllUnique256(String s)
    {
        BitSet bs = new BitSet(256);
        if(s.length()>256)
            return false;
        for(char c: s.toCharArray())
        {
            if(bs.get(c))
                return false;
            bs.set(c);
        }
        return true;
    }
    // O(n log n)
    private static boolean hasAllUniqueUsingSort(Character[] s)
    {
        QuickSort.sort(s);
        for (int i = 0; i < s.length-1; i++) {
            if(s[i]==s[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAllUnique("uniqstr"));
        System.out.println(hasAllUnique("nonuniquestring"));
        System.out.println(hasAllUnique256("uniqstr"));
        System.out.println(hasAllUnique256("nonuniquestring"));
        System.out.println(hasAllUniqueUsingSort(Strings.toCharacterArray("uniqstr")));
        System.out.println(hasAllUniqueUsingSort(Strings.toCharacterArray("nonuniquestring")));
    }
}
