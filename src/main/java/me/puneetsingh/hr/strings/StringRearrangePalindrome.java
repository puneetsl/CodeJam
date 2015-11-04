package me.puneetsingh.hr.strings;

import java.util.HashSet;

/*
    Check if characters of a given string can be rearranged to form a palindrome
    http://geeksquiz.com/check-characters-given-string-can-rearranged-form-palindrome/
 */

public class StringRearrangePalindrome {
    static void stub(boolean b) {
    }//function to do nothing but to digest boolean value and return nothing

    private static boolean isRearrangeableToPalindrome(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            stub(hs.contains(c) ? hs.remove(c) : hs.add(c));
        }
        return hs.size() <= 1;
    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(isRearrangeableToPalindrome("abcca"));
    }
}
