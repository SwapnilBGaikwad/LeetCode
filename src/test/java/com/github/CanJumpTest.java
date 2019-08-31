package com.github;

import org.junit.Test;

public class CanJumpTest {
    @Test
    public void test() {
        CanJump solution = new CanJump();
        int[] arr = {2, 0, 1, 0, 1};
        boolean canJump = solution.canJump(arr);
        System.out.println("canJump " + canJump);
    }
}