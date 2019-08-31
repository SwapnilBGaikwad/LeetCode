package com.github;

import java.util.LinkedList;
import java.util.List;

public class CommonCharInString {
    public List<String> commonChars(String[] A) {
        int[][] mapArr = new int[A.length][26];

        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                int count = mapArr[i][index];
                if (count == 0) {
                    mapArr[i][index] = 1;
                } else {
                    mapArr[i][index] = count + 1;
                }
            }
        }
        List<String> list = new LinkedList<>();
        for (char k = 0; k < 26; k++) {
            int i, cnt = Integer.MAX_VALUE;
            for (i = 0; i < A.length; i++) {
                int count = mapArr[i][k];
                if (count == 0) {
                    break;
                }
                cnt = Math.min(count, cnt);
            }
            if (i == A.length) {
                while (cnt > 0) {
                    list.add(String.valueOf((char) ('a' + k)));
                    cnt--;
                }
            }
        }
        return list;
    }
}
