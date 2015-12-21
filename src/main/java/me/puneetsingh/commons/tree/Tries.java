package me.puneetsingh.commons.tree;


import com.sun.org.apache.xml.internal.utils.Trie;
import me.puneetsingh.utils.Strings;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Tries {
    public Character data;
    public Tries root = null;
    public LinkedHashMap<Character, Tries> nodes = new LinkedHashMap<Character, Tries>();
    public String leaf;
    private Tries(Character c)
    {
        data = c;

    }
    public Tries()
    {
        root = new Tries('~');

    }
    public void insert(String in)
    {
        Character[] sArr = Strings.toCharacterArray(in);
        Tries t=root;
        for (Character c: sArr)
        {
            if(t.nodes.containsKey(c))
            {
                t= t.nodes.get(c);
            }
            else
            {
                t.nodes.put(c,new Tries(c));
                t = t.nodes.get(c);
            }
        }
        t.leaf = in;
    }

    public boolean contains(String s)
    {
        Character[] sArr = Strings.toCharacterArray(s);
        Tries t=root;
        for (Character c: sArr)
        {
            if(t.nodes.containsKey(c))
            {
                t= t.nodes.get(c);
            }
            else
            {
                return false;
            }
        }
        return s.equals(t.leaf);
    }

}
