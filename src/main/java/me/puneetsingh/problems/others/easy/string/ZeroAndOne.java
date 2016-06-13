package me.puneetsingh.problems.others.easy.string;


public class ZeroAndOne {
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "1010?001?";

        int i=0;
        for(char c: s.toCharArray())
        {
            if(c=='?')
                i++;
        }
        double val = Math.pow(2.0f,i);
        for(int j=0; j< val; j++)
        {
            System.out.println(getBits(j,i));
        }

    }
    public static String getBits(int j,int i)
    {
        String bin = Integer.toBinaryString(j);
        int remaining = i - bin.length();
        StringBuilder sb= new StringBuilder();
        for (int k = 0; k < remaining; k++) {
            sb.append("0");
        }
        bin = sb.toString() + bin;
        return bin;
    }
}
