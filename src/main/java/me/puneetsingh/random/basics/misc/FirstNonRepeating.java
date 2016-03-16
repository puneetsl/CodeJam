package me.puneetsingh.random.basics.misc;

import me.puneetsingh.utils.Strings;

import java.util.HashSet;

import java.util.LinkedHashSet;

public class FirstNonRepeating {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(findFirstNonRepeatingOrder(s));
        System.out.println(findFirstNonRepeatingNoOrder(s));
        System.out.println(findFirstNonRepeatingNoOrder2(s));
    }

    private static char findFirstNonRepeatingOrder(String s) {

        if (s == null || s.length() == 0)
            return '~';

        char curr = s.charAt(0);
        short x = 1;

        if (s.length() == 1)
            return curr;

        for (int i = 1; i < s.length(); i++) {
            if (curr == s.charAt(i))
                x++;
            else {
                if (x == 1)
                    return curr;
                else {
                    curr = s.charAt(i);
                    x = 1;
                }
            }
        }
        return '~';
    }

    private static char findFirstNonRepeatingNoOrder(String s) {
        LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
        HashSet<Character> trashed = new HashSet<Character>();
        Character[] car = Strings.toCharacterArray(s);
        for (Character aCar : car) {
            if (lhs.contains(aCar) && !trashed.contains(aCar)) {
                trashed.add(aCar);
                lhs.remove(aCar);
            } else {
                lhs.add(aCar);
            }
        }
        return lhs.iterator().next();
    }

    private static char findFirstNonRepeatingNoOrder2(String s) {

        int i, n;
        HashSet<Character> mp = new HashSet<Character>();
        char res = '~';
        n = s.length();
        Character[] car = Strings.toCharacterArray(s);
        for (i = n - 1; i >= 0; i--) {
            if (!mp.contains(car[i]))
                res = car[i];
            mp.add(car[i]);

        }
        return res;
    }
}
