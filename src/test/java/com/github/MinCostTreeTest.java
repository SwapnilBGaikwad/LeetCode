package com.github;

import org.junit.Assert;
import org.junit.Test;

public class MinCostTreeTest {
    @Test
    public void test() {
        int[] arr = {6, 2, 4};
        MinCostTree tree = new MinCostTree();
        Assert.assertEquals(32, tree.getCost(arr));
    }

    @Test
    public void test1() {
        int[] arr = {7, 12, 8, 10};
        MinCostTree tree = new MinCostTree();
        Assert.assertEquals(284, tree.getCost(arr));
    }

    @Test
    public void test2() {
        int[] arr = {6, 15, 5, 2};
        MinCostTree tree = new MinCostTree();
        Assert.assertEquals(175, tree.getCost(arr));
    }
}