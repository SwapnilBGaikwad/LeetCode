package com.github;

import org.junit.Test;

public class FindJudgeTest {
    @Test
    public void test() {
        int[][] arr = {{1, 3}, {2, 3}, {3, 1}};
        FindJudge findJudge = new FindJudge();
        int judge = findJudge.findJudge(3, arr);
        System.out.println("judge :: " + judge);
    }
}