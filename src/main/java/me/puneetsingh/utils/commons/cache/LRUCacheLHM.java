package me.puneetsingh.utils.commons.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLHM<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCacheLHM(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize+1;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
    public void setCapacity(int i) {
        this.cacheSize = i+1;
    }
    public void printKeysAndValues() {
        System.out.println(this);
    }
}
