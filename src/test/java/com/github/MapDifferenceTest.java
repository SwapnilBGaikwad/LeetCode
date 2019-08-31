package com.github;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDifferenceTest {
    @Test
    public void test() {
        MapDifference mapDifference = new MapDifference();
        Map<String, String[]> existingMap = new HashMap<>();
        existingMap.put("a", new String[]{"1", "2"});
        existingMap.put("b", new String[]{"3", "4"});
        Map<String, String[]> newMap = new HashMap<>();
        newMap.put("b", new String[]{"4", "5"});
        newMap.put("c", new String[]{"1", "2"});

        List<List<MapDifference.Record>> lists = mapDifference.mapDiff(existingMap, newMap);
        for (List<MapDifference.Record> list : lists) {
            System.out.println(list);
        }
    }
}