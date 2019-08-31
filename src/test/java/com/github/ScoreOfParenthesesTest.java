package com.github;

import org.junit.Test;

public class ScoreOfParenthesesTest {
    @Test
    public void test() {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        int score = scoreOfParentheses.scoreOfParentheses("(()(()))");
        System.out.println("Score " + score);
    }
}