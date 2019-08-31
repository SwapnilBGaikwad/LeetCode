package com.github;

import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        System.out.println("lruCache.get(3) " + lruCache.get(3));
        System.out.println("lruCache.get(2) " + lruCache.get(2));
        lruCache.put(4, 3);
        System.out.println("lruCache.get(2) " + lruCache.get(2));
        System.out.println("lruCache.get(3) " + lruCache.get(3));
        System.out.println("lruCache.get(4) " + lruCache.get(4));
    }
}