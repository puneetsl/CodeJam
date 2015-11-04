package me.puneetsingh.commons.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache<K, V> {
    private ConcurrentLinkedDeque<K> ll;
    private ConcurrentHashMap<K, V> hm;
    private int size;

    public LRUCache(int size) {
        ll = new ConcurrentLinkedDeque<K>();
        hm = new ConcurrentHashMap<K, V>(size);
        this.size = size;
    }

    public int size() {
        return size;
    }

    public void clear() {
        hm.clear();
        ll.clear();
    }

    public void put(K k, V v) {
        if (hm.containsKey(k)) {
            hit(k, v);
            return;
        }
        if (size > hm.size()) {
            ll.add(k);
            hm.put(k, v);
        } else {
            K tempK = ll.remove();
            hm.remove(tempK);
            ll.add(k);
            hm.put(k, v);
        }
    }

    public V get(K o) {
        if (hm.containsKey(o)) {
            return hit(o, hm.get(o));
        } else
            return null;
    }

    private V hit(K o, V v) {
        //if we hit an existing key move the key to the front of the queue
        ll.remove(o);
        ll.add(o);
        hm.put(o, v);
        return v;
    }

    public void remove(K o) {
        ll.remove(o);
        hm.remove(o);
    }

    public void setCapacity(int i) {
        size = i;
    }

    public void printKeysAndValues() {
        System.out.print("{ ");
        int i = 0;
        for (Object k : ll.toArray()) {
            System.out.print(k + "=" + hm.get(k));
            if (i < ll.size() - 1)
                System.out.print(", ");
            i++;
        }
        System.out.print(" }");
        System.out.println();
    }
}
