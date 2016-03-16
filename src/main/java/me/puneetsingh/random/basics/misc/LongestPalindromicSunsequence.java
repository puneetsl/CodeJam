package me.puneetsingh.random.basics.misc;

public class LongestPalindromicSunsequence {
    public static void main (String[] args) throws java.lang.Exception
    {
        longestPalindromicSubsequenceN2("aaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaa");
    }
    public static void longestPalindromicSubsequenceN2(String s)
    {
        int max=0;
        int index = 0;
        boolean odd=true;
        StringBuilder sb = new StringBuilder();
        //odd
        for(int i=0; i< s.length(); i++)
        {
            int k=0;
            while((i-k>0&&i+k<s.length())&&(s.charAt(i-k)==s.charAt(i+k)))
            {
                k++;
            }
            int val = 2*k+1;
            if(max < val)
            {
                index = i;
                max = val;
            }
        }
        //even
        for(int i=0; i< s.length(); i++)
        {
            int k=0;
            while((i-k>0&&i+k+1<s.length())&&(s.charAt(i-k)==s.charAt(i+1+k)))
            {
                k++;
            }
            int val = 2*k;
            if(max < val)
            {
                index = i;
                max = val;
                odd = false;
            }
        }
        int k=0;
        if(odd)
        {

            sb.append(String.valueOf(s.charAt(index+k)));
            k++;
            while((index-k>0&&index+k<s.length())&&(s.charAt(index-k)==s.charAt(index+k)))
            {
                sb.append(String.valueOf(s.charAt(index+k)));
                sb.insert(0,String.valueOf(s.charAt(index-k)));
                k++;
            }
            System.out.println(sb.toString());
        }
        else
        {
            while((index-k>0&&index+k+1<s.length())&&(s.charAt(index-k)==s.charAt(index+1+k)))
            {
                sb.append(String.valueOf(s.charAt(index + k + 1)));
                sb.insert(0,String.valueOf(s.charAt(index-k)));
                k++;
            }
            System.out.println(sb.toString());
        }
    }
}
