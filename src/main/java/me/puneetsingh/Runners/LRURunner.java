package me.puneetsingh.runners;

import me.puneetsingh.commons.cache.LRUCache;

public class LRURunner {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lr = new LRUCache<Integer, Integer>(5);
        for (int i = 0; i < 5; i++) {
            lr.put(i, i);
        }
        lr.printKeysAndValues();
        lr.put(3, 3);
        lr.printKeysAndValues();
        lr.put(10, 10);
        lr.printKeysAndValues();
        lr.put(11, 11);
        lr.printKeysAndValues();
        lr.put(10, 10);
        lr.printKeysAndValues();
        lr.setCapacity(6);
        lr.put(12, 12);
        lr.printKeysAndValues();
    }

}
