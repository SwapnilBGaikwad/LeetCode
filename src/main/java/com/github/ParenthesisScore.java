package com.github;

import java.util.Stack;

public class ParenthesisScore {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(-1);
            } else {
                int sum = 0;
                while (stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(getSum(sum));
            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

    private int getSum(int sum) {
        if (sum == 0) {
            return 1;
        }
        return 2 * sum;
    }
}