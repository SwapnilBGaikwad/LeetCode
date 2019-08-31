package com.github;

import org.junit.Test;

import java.util.Arrays;

public class RecurseMatrixTest {
    @Test
    public void test() {
        RecurseMatrix recurseMatrix = new RecurseMatrix();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        recurseMatrix.floodFill(image, 1, 1, 2);
        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
    }
}