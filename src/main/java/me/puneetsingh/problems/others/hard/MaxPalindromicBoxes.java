package me.puneetsingh.problems.others.hard;


public class MaxPalindromicBoxes {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(getMaxPalindromicBoxes(s));
    }

    private static int getMaxPalindromicBoxes(String s) {
        if(s.equals("")) return 0;
        int i =1, j = s.length()-1;
        int st =0, en = s.length();
        int count=0;
        boolean one = true;

        while(i<=j+1)
        {
            String s1 = s.substring(st,i);
            String s2 = s.substring(j,en);
//            System.out.println(s1+":"+s2+","+i+":"+j);
            if(s1.equals(s2))
            {
                if(i<=j)
                    count+=2;
                else
                    count++;
                st=i;
                i++;
                en=j;
                j--;
                one = false;
            }
            else
            {
                i++;j--;
                one = true;
            }
        }
        if(one)
            count++;
        return count;
    }
}
