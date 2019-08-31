package com.github;

public class MinCostInMatrix {
    int[][] matrix;

    int minCost(int[][] cost, int m, int n) {
        matrix = new int[m + 1][n + 1];
        int costUtil = minCostUtil(cost, m, n);
        return costUtil;
    }

    int minCostUtil(int cost[][], int m, int n) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];

        if (matrix[m][n] != 0) {
            return matrix[m][n];
        }
        int no1 = minCostUtil(cost, m - 1, n - 1);
        int no2 = minCostUtil(cost, m - 1, n);
        int no3 = minCostUtil(cost, m, n - 1);
        int res = cost[m][n] + Math.min(Math.min(no1, no2), no3);
        matrix[m][n] = res;
        return res;
    }
}
