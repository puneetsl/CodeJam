package me.puneetsingh.commons.cache;

import java.util.*;

public class SortedMapCountSet<K> implements Iterable{
    public enum Order {FORWARD, REVERSE}
    HashMap<K,Integer> _actualMap = new HashMap<>();
    SortedMap<Integer, HashSet<K>> _reverseMap = null;
    public SortedMapCountSet()
    {
        _reverseMap = new TreeMap<>(java.util.Collections.reverseOrder());
    }
    public SortedMapCountSet(Order o)
    {
        if(o.equals(Order.FORWARD))
            _reverseMap = new TreeMap<>();
        else
            _reverseMap = new TreeMap<>(java.util.Collections.reverseOrder());
    }
    public void add(K key)
    {
        if(!_actualMap.containsKey(key)) {
            _actualMap.put(key, 1);
            if(!_reverseMap.containsKey(1))
                _reverseMap.put(1,new HashSet<K>());
            _reverseMap.get(1).add(key);
        }
        else
        {
            int count = _actualMap.get(key);
            _actualMap.put(key,count+1);
            _reverseMap.get(count).remove(key);
            if(!_reverseMap.containsKey(count+1))
                _reverseMap.put(count+1,new HashSet<K>());
            _reverseMap.get(count+1).add(key);
        }
    }


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    class MyIterator <T> implements Iterator<T> {

        Iterator<Map.Entry<Integer, HashSet<K>>> it = _reverseMap.entrySet().iterator();
        Map.Entry<Integer, HashSet<K>> current=null;
        Iterator<K> valItr = null;
        public MyIterator()
        {
            if(current==null&&it.hasNext())
                current=it.next();
            if(valItr==null&&current!=null)
                valItr= current.getValue().iterator();

        }
        public boolean hasNext() {

           if(current==null||valItr==null)
               return false;
           else
           {
               if(valItr.hasNext())
                   return true;
               else while(it.hasNext()&&!valItr.hasNext())
               {
                   current = it.next();
                   valItr = current.getValue().iterator();
               }
               if(valItr.hasNext())
                   return true;
               else return false;
           }

        }

        public T next() {
            return (T) valItr.next();
        }
    }
}
