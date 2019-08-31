package com.github;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindTriplet {
    public List<List<Integer>> findTriplet(int[] arr) {
        List<List<Integer>> lists = new LinkedList<>();
        int i = 0, j = arr.length - 1;
        while (j - i > 1) {
            int sum = arr[i] + arr[j];
            if (sum <= 0) {
                int finalSum = arr[j - 1] + sum;
                if (finalSum == 0) {
                    lists.add(Arrays.asList(arr[i], arr[j], arr[j - 1]));
                    i++;
                } else if (finalSum < 0) {
                    i++;
                } else {
                    j--;
                }
            } else {
                int finalSum = arr[i + 1] + sum;
                if (finalSum == 0) {
                    lists.add(Arrays.asList(arr[i], arr[j], arr[i + 1]));
                    j--;
                } else if (finalSum < 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return lists;
    }
}
