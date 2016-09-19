package me.puneetsingh.problems.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonPrefix {
    public String longestCommonPrefixSimple(String[] strs) {
        List<Character> common = new LinkedList<>();
        if(strs.length==0) return null;
        for(int i=0;i<strs[0].length();i++)
            common.add(new Character(strs[0].charAt(i)));
        for (int i=1;i<strs.length;i++) {
            getCommon(strs[i], common);
        }
        return to_str(common);
    }

    private String to_str(List<Character> common) {
        StringBuilder sb = new StringBuilder();
        for (char c: common) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void getCommon(String s, List<Character> common) {
        int size = s.length() < common.size() ? s.length() : common.size();
        int i;
        for (i=0; i < size; i++) {
            if(common.get(i)!=s.charAt(i)){
                common.subList(i, common.size()).clear();
                return;
            }
        }
        common.subList(i, common.size()).clear();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"a","aa"};
        System.out.println(lcp.longestCommonPrefixSimple(strs));
    }
}
