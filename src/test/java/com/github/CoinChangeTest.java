package com.github;

import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void test() {
        int[] arr = {2,5,10,1};
        CoinChange solution = new CoinChange();
        int coinChange = solution.coinChange(arr, 27);
        System.out.println(coinChange);
    }
}