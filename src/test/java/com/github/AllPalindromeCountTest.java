package com.github;

import org.junit.Test;

public class AllPalindromeCountTest {
    @Test
    public void test() {
        AllPalindromeCount allPalindromeCount = new AllPalindromeCount();
        int count = allPalindromeCount.countSubstrings("aaa");
        System.out.println(count);
    }
}