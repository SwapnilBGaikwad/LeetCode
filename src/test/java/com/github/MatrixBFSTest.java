package com.github;

import org.junit.Test;

import java.util.Arrays;

public class MatrixBFSTest {
    @Test
    public void test() {
        MatrixBFS matrixBFS = new MatrixBFS();
        int[][] distOrder = matrixBFS.allCellsDistOrder(2, 2, 0, 1);
        for (int[] nos : distOrder) {
            System.out.println(Arrays.toString(nos));
        }
    }
}