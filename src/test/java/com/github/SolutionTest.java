package com.github;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionTest {
    @Test
    public void test() {
        PriorityQueue heap = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o2 - o1);
    }
}