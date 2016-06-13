package me.puneetsingh.problems.others.easy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueStringRev {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>(20);
        l.add("abc");l.add("bcd");l.add("cde");l.add("cba");
        l.add("abc");l.add("xyz");l.add("pqr");l.add("dcb");
        l.add("uvw");l.add("rst");l.add("lmn");l.add("mno");
        List<String> list = getUnique(l);
        System.out.println(list.size());
        for(String s: list)
        {
            System.out.println(s);
        }
    }
    public static List<String> getUnique(List<String> lst)
    {
        HashMap<Integer,String> hm = new HashMap<>();
        for(String l : lst)
        {
            hm.put(getHash(l),l);
        }
        return new ArrayList<>(hm.values());
    }
    private static int getHash(Object key) {

        if(key instanceof String)
        {
            int h=1;
            for(int i=0;i<((String) key).length();i++)
            {
                h = h*(int)Math.pow(nthPrime(((String) key).charAt(i)-'a'),position(i,((String) key).length())+1);
                h %= Integer.MAX_VALUE/103;//27th prime number
            }
            System.out.println(h);
            return h;
        }
        else return key.hashCode();
    }

    private static int position(int i, int length) {
        if(i>length/2)
        {
            return i;
        }
        else
        {
            return length-i-1;
        }
    }

    public static int nthPrime(int n) {
        int candidate, count;
        for(candidate = 2, count = 0; count < n; ++candidate) {
            if (isPrime(candidate)) {
                ++count;
            }
        }
        // The candidate has been incremented once after the count reached n
        return candidate-1;
    }
    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int)Math.sqrt(n) + 1;
        for(int i = 5; i < m; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
