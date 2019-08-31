package com.github;

import org.junit.Test;

import java.util.List;

public class FindTripletTest {
    @Test
    public void test() {
        FindTriplet findTriplet = new FindTriplet();
        int[] arr = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> triplets = findTriplet.findTriplet(arr);
        System.out.println(triplets);
    }
}