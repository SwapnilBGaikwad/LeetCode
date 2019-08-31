package com.github;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        if (S.length() == 0) {
            return 0;
        }
        if (S.equals("()")) {
            return 1;
        }
        List<String> split = split(S);
        if (split.size() == 1) {
            return 2 * scoreOfParentheses(S.substring(1, S.length() - 1));
        }
        int score = 0;
        for (String s : split) {
            score += scoreOfParentheses(s);
        }
        return score;
    }

    private List<String> split(String str) {
        System.out.println("Processing " + str);
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            builder.append(ch);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return list;
    }
}