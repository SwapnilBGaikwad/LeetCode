package com.github;

import org.junit.Test;

public class DecodeStringTest {
    @Test
    public void test() {
        DecodeString solution = new DecodeString();
        String decodeString = solution.decodeString("2[abc]3[cd]ef");
        System.out.println("decodeString " + decodeString);
    }
}