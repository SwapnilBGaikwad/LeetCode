package com.github;

import org.junit.Test;

public class MinCostInMatrixTest {
    @Test
    public void test() {
        MinCostInMatrix minCostInMatrix = new MinCostInMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        int minCost = minCostInMatrix.minCost(matrix, 2, 2);
        System.out.println("min cost " + minCost);
    }
}