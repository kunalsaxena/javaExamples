package com.techiekunal.coding.interview.java;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * My LRU Implementation
 * Requirements - fix size queue which keeps data in cache >> when cache is full it removes least recently used elements
 * Scalable
 * Choice of DS - ConcurrentMap for storage | Blocking Deque for frequency
 */
public class LRUCacheImpl<KEY, VAL> {

    private final Map<KEY, VAL> storageMap;
    private final Deque<KEY> freqQueue;


    public LRUCacheImpl(Map<KEY, VAL> map, Deque<KEY> deQue, int capacity) {
        this.storageMap = map;
        this.freqQueue = deQue;
    }

    public VAL get(KEY key) {
        VAL v = storageMap.get(key);
        updateFrequency(key);
        return v;
    }

    public void put(KEY key, VAL val) {
        updateFrequency(key);
        storageMap.put(key, val);
    }

    private void updateFrequency(KEY key) {
        if(!freqQueue.offerLast(key)) { // false if deque is full
            clearOldKeys(1);
        }
        updateFrequency(key);
    }

    private void clearOldKeys(int noOfKeys) {
        while (noOfKeys > 0) {
            freqQueue.removeFirst();
        }
    }

    /**
     * Runner
     */
    public static void main(String[] args) {
        int capacity = 100;
        //LRUCacheImpl lruCache = new LRUCacheImpl(new ConcurrentHashMap<Integer, String>(capacity), new LinkedBlockingDeque<Integer>(capacity));
    }
}
