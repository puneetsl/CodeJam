package me.puneetsingh.basics.misc;


import java.util.HashMap;

public class WaysToReach {
    static HashMap<Integer,Integer> prev = new HashMap<Integer,Integer>();
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] a = {1,2,3};
        int ways = toReach(a,10,0);
        System.out.println(ways);

    }
    public static int toReach(int[] a, int x, int c)
    {
        //TODO: Complete this code
        if(c==x)
        {
            return 1;
        }
        if(c>x)
        {
            return 0;
        }
        int ways=0;
        int tempways=0;
        for(int i=0;i<a.length;i++)
        {

            if(prev.containsKey(tempways))
            {
                tempways = prev.get(c);
                return tempways+1;
            }
            else
            {
                ways=ways+toReach(a,x,c+a[i]);
            }
            prev.put(c,ways);
        }
        return ways;
    }
}
