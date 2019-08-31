package com.github;

import java.util.*;

class FindJudge {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] t : trust) {
            List<Integer> list = map.get(t[1]);
            if (list == null) {
                list = new LinkedList<>();
                list.add(t[0]);
                map.put(t[1], list);
            } else {
                list.add(t[0]);
            }
        }
        for (int i = 1; i <= N; i++) {
            List<Integer> list = map.get(i);
            if (list != null && map.get(i).size() == N - 1) {
                return i;
            }
        }
        return -1;
    }
}