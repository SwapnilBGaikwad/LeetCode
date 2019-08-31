package com.github;

import java.util.Arrays;

class AllPalindromeCount {
    private int[][] cnt;

    public int countSubstrings(String s) {
        cnt = new int[s.length()][s.length()];
        for (int[] ints : cnt) {
            Arrays.fill(ints, -1);
        }
        return countSubstrings(s, 0, s.length() - 1);
    }

    private int countSubstrings(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (cnt[i][j] != -1) {
            return cnt[i][j];
        }
        int cnt1 = countSubstrings(s, i + 1, j);
        cnt[i + 1][j] = cnt1;
        int cnt2 = countSubstrings(s, i, j - 1);
        cnt[i][j - 1] = cnt2;
        int cnt3 = countSubstrings(s, i + 1, j - 1);
        cnt[i + 1][j - 1] = cnt3;
        cnt[i][j] = cnt1 + cnt2 - cnt3;
        if (isPal(s, i, j)) {
            return ++cnt[i][j];
        } else {
            return cnt[i][j];
        }
    }

    private boolean isPal(String str, int i, int j) {
        boolean res = true;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}