package me.puneetsingh.problems.leetcode;

import java.util.*;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k<1) return new ArrayList<>(k);
        PriorityQueue<Pair<Integer>> heap = new PriorityQueue<>(k);
        HashMap<Integer, Pair<Integer>> all = new HashMap<>();
        for(int i: nums)
        {
            if(all.containsKey(i)) {
                all.get(i).value++;
            }
            else {
                all.put(i, new Pair<>(i,1));
            }
            if(heap.size()<=k) {
                if(heap.contains(all.get(i)))
                {
                    heap.remove(all.get(i));
                }
                heap.add(all.get(i));
            }
            else if(heap.peek().value < all.get(i).value) {
                heap.poll();
                if(heap.contains(all.get(i)))
                {
                    heap.remove(all.get(i));
                }
                heap.add(all.get(i));
            }

        }
        heap.add(heap.poll());
        List<Integer> lst = new ArrayList<>(k);
        while(!heap.isEmpty())
        {
            System.out.println(heap.peek().key+":"+heap.peek().value);
            lst.add(heap.poll().key);
        }
        return lst;
    }
    static class Pair<K> implements Comparable<Pair<K>>{
        public K key;
        public Integer value;
        public Pair(K k, Integer v)
        {
            key = k;
            value = v;
        }

        @Override
        public int compareTo(Pair<K> o) {
            return this.value<o.value ?-1: this.value>o.value ?1:0;
        }

    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,1,8,8,8,1,1,1,3,3,3,3,3,3};
        TopKFrequent tf = new TopKFrequent();
        List<Integer> l = tf.topKFrequent(a,-1);
        for (int i : l) {
            System.out.println(i);
        }
    }
}
