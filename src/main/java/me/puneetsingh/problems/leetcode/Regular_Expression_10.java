package me.puneetsingh.problems.leetcode;


import java.util.ArrayList;
import java.util.regex.Pattern;

public class Regular_Expression_10 {


    public static void main(String[] args) {
        String s = "aa";
        String r = "a";
        Regular_Expression_10 re10 = new Regular_Expression_10();
        System.out.println(re10.isMatch(s, r));
        System.out.println();
    }

    public boolean isMatch(String s, String p) {
        boolean[][] DP = new boolean[s.length()+1][p.length()+1];
        DP[0][0]=true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < DP[0].length; i++) {
            if (p.charAt(i-1) == '*') {
                DP[0][i] = DP[0][i - 2];
            }
        }
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<p.length();j++)
            {
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
                    DP[i+1][j+1]=DP[i][j];
                else if(p.charAt(j)=='*') {
                    DP[i + 1][j + 1] = DP[i + 1][j-1];
                    if (p.charAt(j-1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                        DP[i+1][j+1] = DP[i+1][j+1] ||DP[i][j+1];
                    }
                }
            }
        }
        for(int i=0;i<s.length()+1;i++)
        {
            for(int j=0;j<p.length()+1;j++)
            {
                System.out.printf(DP[i][j]+" ");
            }
            System.out.println();
        }
        return DP[DP.length-1][DP[0].length-1];
    }
}
