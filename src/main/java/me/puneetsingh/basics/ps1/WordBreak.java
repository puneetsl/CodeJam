package me.puneetsingh.basics.ps1;


import me.puneetsingh.utils.Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static List<String> wordBreak(String s, Set<String> wordDict) {

        WordTree wt = new WordTree("/",0);//root
        wt.children = getPositions(s,0,wordDict);
        if(wt.children.size()==0)
            return null;
        else
        {

            createTree(s, wt.children, wordDict);
        }
        System.out.println("Done Creating tree");
        return DFSTree(wt.children);
    }

    private static List<String> DFSTree(ArrayList<WordTree> children) {
        ArrayList<String> retList = new ArrayList<String>();
        DFSTree(children,retList,"");
        if(retList.size()==0)
            return null;
        return retList;
    }

    private static void DFSTree(ArrayList<WordTree> children, ArrayList<String> retList, String s) {

        for (WordTree w:children)
        {

            String temp = s;
            if(w.word.val.endsWith("$")) {
                s = s+ w.word.val.substring(0,w.word.val.length()-1);
                retList.add(s);
            }
            else{
                s = s+ w.word.val+" ";
            }
            DFSTree(w.children,retList, s);
            s= temp;
        }
    }

    private static void createTree(String s, ArrayList<WordTree> children, Set<String> wordDict) {
        for (WordTree w:children)
        {
            w.children = getPositions(s,w.word.position+1,wordDict);

            if(w.children.size()!=0&&!w.word.val.endsWith("$"))
            {
                createTree(s, w.children, wordDict);
            }
        }

    }

    private static ArrayList<WordTree> getPositions(String t, int low, Set<String> wordDict)
    {
        char[] sArr = t.substring(low).toCharArray();
        ArrayList<WordTree> pos = new ArrayList<WordTree>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (Character c:sArr)
        {
            sb.append(c);
            if(wordDict.contains(sb.toString()))
            {
                if(i!=sArr.length-1) {
                    WordTree p = new WordTree(sb.toString(), i+low);
                    pos.add(p);
                }
                else
                {
                    WordTree p = new WordTree(sb.toString()+"$",i+low);
                    pos.add(p);
                }
            }

            i++;
        }
        return pos;
    }
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<String>();
        String vals[] = {"a","aab","aaab","aaaab","aaaaab","aaaaaab","aaaaaaab","aaaaaaaab","aaaaaaaaab","aaaaaaaaaab"};
        for (String s:vals)
        {
            dictionary.add(s);
        }
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        List<String> result1 = wordBreak(str, dictionary);
        if(result1!=null)
            for (String s: result1)
                System.out.println(s);
        else
            System.out.println("Not Found!!");
    }
}
class StringPos{
    String val;
    int position;
}
class WordTree{
    StringPos word = new StringPos();
    ArrayList<WordTree> children = new ArrayList<WordTree>();
    WordTree(String s, int i)
    {
        word.val = s;
        word.position = i;
    }
}