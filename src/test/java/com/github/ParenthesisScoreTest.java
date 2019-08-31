package com.github;

import org.junit.Test;

public class ParenthesisScoreTest {
    @Test
    public void test() {
        ParenthesisScore scoreOfParentheses = new ParenthesisScore();
        int score = scoreOfParentheses.scoreOfParentheses("(()(()))");
        System.out.println("Score " + score);
    }
}