package me.puneetsingh.problems.others.easy.misc;

public class LongestPalindromicSunsequence {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(longestPalindromicSubsequenceN2("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
    }

    public static String longestPalindromicSubsequenceN2(String s) {
        int max = 0;
        String mStr = "";
        for (int i = 0; i < s.length(); i++) {
            String l = getPalindrome(i, s);
//            System.out.println(l);
            if (max < l.length()) {
                max = l.length();
                mStr = l;
            }
        }
        return mStr;
    }

    private static String getPalindrome(int i, String s) {
        //odd
        int j = i - 1;
        int k = i + 1;
        String o=s.substring(i,i+1),e="";
        System.out.println("i=> "+j+":"+k);
        while (j >= 0 && k < s.length())
        {
            if (s.charAt(j) == s.charAt(k))
            {
                o = s.substring(j, k + 1);
                j--;
                k++;

                System.out.println("O => "+o);
            } else
                break;
        }
        if(i+1 < s.length())
        if(s.charAt(i) == s.charAt(i+1))
        {
            j = i - 1;
            k = i + 2;
            e = s.substring(i,k);
            while (j > 0 && k < s.length())
            {
                if (s.charAt(j) == s.charAt(k))
                {
                    j--;
                    k++;
                } else
                    e = s.substring(j, k + 1);
            }
        }
        return o.length()<e.length()? e:o;
    }
}
