package com.github;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringPartition {
    public List<Integer> partitionLabels(String str) {
        Map<Character, Range> rangeMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Range range = rangeMap.get(key);
            if (range == null) {
                rangeMap.put(key, new Range(i));
            } else {
                range.update(i);
            }
        }
        List<Integer> partitions = new ArrayList<>();
        Range range = rangeMap.get(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char key = str.charAt(i);
            Range newRange = rangeMap.get(key);
            if (range.end > newRange.start) {
                range.update(newRange.end);
            } else {
                partitions.add(range.size());
                range = newRange;
            }
        }
        partitions.add(range.size());
        return partitions;
    }

    private static class Range {
        private int start, end;

        Range(int start) {
            this.start = start;
            this.end = start;
        }

        void update(int index) {
            if (end < index) {
                end = index;
            }
        }

        Integer size() {
            return end - start + 1;
        }
    }
}