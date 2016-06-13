package me.puneetsingh.problemsets.ps1;


import java.util.ArrayList;
import java.util.HashSet;

public class WordBreakNotMine {


    public static ArrayList<String> wordBreak(String s, HashSet<String> dict) {
        //create an array of ArrayList<String>
        ArrayList<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            if( dp[i] == null )
                continue;

            for(String word:dict){
                int len = word.length();
                int end = i+len;
                if(end > s.length())
                    continue;

                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        if(dp[s.length()] == null)
            return null;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    public static void dfs(ArrayList<String> dp[],int end,ArrayList<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }

            result.add(path);
            return;
        }

        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<String>();
        String vals[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        for (String s:vals)
        {
            dictionary.add(s);
        }
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";


        ArrayList<String> result1 = wordBreak(str, dictionary);
        if(result1!=null)
            for (String s: result1)
                System.out.println(s);
        else
            System.out.println("Not Found!!");
    }
}
