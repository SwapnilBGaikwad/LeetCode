package com.github;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int count = coinChange(coins, amount, coins.length - 1, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int coinChange(int[] coins, int amount, int index, int count) {
        if(index < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(amount == 0) {
            return count;
        }
        return Math.min(coinChange(coins, amount - coins[index], index, count + 1),
                coinChange(coins, amount, index - 1, count));
    }
}
