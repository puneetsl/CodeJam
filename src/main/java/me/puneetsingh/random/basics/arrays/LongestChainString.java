package me.puneetsingh.random.basics.arrays;


import java.util.*;

public class LongestChainString {
    static int maxn=10000;

    SortedMap< String,Integer > hm = new TreeMap<>();
    int dp[] = new int[maxn];

    public int LongestChain(List<String> lst)
    {

        Collections.reverse(lst);

        int N=lst.size();
        hm.put(lst.get(0), 0);
        dp[0]=1;
        int maxTillNow =0;
        int answer=dp[0];

        for (int i=1;i<N;i++){
            dp[i]=1;
            String s=lst.get(i);

            int size = lst.size();
            for (int j=0;j<size-1;j++){

                StringBuilder tmpStr = new StringBuilder();
                tmpStr.append(s.toCharArray());
                tmpStr = tmpStr.deleteCharAt(j);
                Integer it =0;
                if(tmpStr!=null)
                    it = hm.get(tmpStr.toString());

                if (it!=null && it!= hm.get(hm.lastKey()))
                    dp[i] = Math.max (dp[i],dp[i+1]);
            }
            answer = Math.max ( answer , dp[i]);

            hm.put(s,i);

        }

        return answer;
    }

    public static void main(String[] args) {
        ArrayList<String> as = new ArrayList<>();
        as.add("a");as.add("b");as.add("ba");
        as.add("bca");as.add("bda");as.add("bdca");
        LongestChainString lcs = new LongestChainString();
        System.out.println(lcs.LongestChain(as));
    }
}
