package me.puneetsingh.random.basics.arrays;


import java.util.Arrays;

public class ThreeNumbersExceptOne {
    public static void main(String[] args) {
        int [] a = {1,1,1,2,2,4,4,5,2,4};
        int [] b = {-2147483648,2147483646,-2147483647,-2147483648,2147483639,-2147483646,-2147483648,-2147483646,-2147483646,-2147483647,2147483646,-2147483647,2147483646};
        int [] c = {1,1,1,2147483647,2147483647,-2147483648,-2147483648,-2147483648};

        System.out.println(singleNumber(b));
        Arrays.sort(b);
        for (int g:b) {
            System.out.print(g+",");
        }
//
//        String m = asBase3(getUnsigned(1));
//        System.out.println(m);
//        m = sum(m,m);m = sum(m,m);
//        System.out.println(getSigned(toBase10(m)));
    }
    public static long singleNumber(int[] nums)
    {
        String p = "";
        p=asBase3(getUnsigned(nums[0]));
        for (int i = 1; i < nums.length; i++) {
//            System.out.println(nums[i]+" : "+getUnsigned(nums[i]));
            p = sum(p,asBase3(getUnsigned(nums[i])));
        }
        if(nums.length%3==2) {
            System.out.println("Been there done that");
            p = sum(p, p);
        }
        System.out.println(p);
       return getSigned(toBase10(p));
    }

    private static long getSigned(Long i) {

        long ret = i+Integer.MIN_VALUE;
        return ret;
    }

    private static long getUnsigned(long num) {
        return num - Integer.MIN_VALUE;
    }

    private static String sum(String x, String l) {

        String b = x.compareTo(l)>0?x:l;
        String s = x.compareTo(l)<0?x:l;
        long ret=0,f=1;
        long m=0,n=0,k=0;
        int j=s.length()-1;
        StringBuilder sb = new StringBuilder();
        for(int i=b.length()-1;i>=0;i--)
        {
            m = b.charAt(i)-'0';
            if(j>=0)
                n = s.charAt(j)-'0';
            else n = 0;
            k = (m+n)%3;
            sb.append(k);
            j--;
        }
        return sb.reverse().toString();
    }

    public static String asBase3(long num) {

        return Long.toString(num,3);
    }
    public static long toBase10(String num) {
        return Long.valueOf(num, 3);
    }

}
