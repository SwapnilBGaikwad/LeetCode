package com.github;

import org.junit.Test;

public class LongestSeatTest {
    @Test
    public void test() {
        LongestSeat longestSeat = new LongestSeat();
        int[] arr = {1, 0, 0, 0, 1, 0, 1};
        int maxDistToClosest = longestSeat.maxDistToClosest(arr);
        System.out.println(maxDistToClosest);
    }
}