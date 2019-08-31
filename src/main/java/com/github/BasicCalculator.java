package com.github;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        return evaluate(getPostFix(getTokens(s)));
    }

    private int evaluate(List<Token> postFix) {
        Stack<Integer> stack = new Stack<>();
        for (Token token : postFix) {
            if (token instanceof Number) {
                stack.push(((Number) token).no);
            } else {
                int result = doOperation(stack.pop(), stack.pop(), ((Operator) token).ch);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private List<Token> getPostFix(List<Token> tokens) {
        List<Token> postfix = new LinkedList<>();
        Stack<Operator> stack = new Stack<>();
        for (Token token : tokens) {
            if (token instanceof Number) {
                postfix.add(token);
                continue;
            }
            Operator operator = (Operator) token;
            if (operator.ch == '(') {
                stack.push(operator);
            } else if (operator.ch == ')') {
                while (stack.peek().ch != '(') {
                    postfix.add(stack.pop());
                }
                stack.pop();
            } else {
                while (stack.size() > 0
                        && !stack.peek().isParenthesis()
                        && stack.peek().compareTo(operator) >= 0) {
                    postfix.add(stack.pop());
                }
                stack.push(operator);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private List<Token> getTokens(String str) {
        List<Token> tokens = new LinkedList<>();
        int no = 0;
        boolean prevDigit = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                no = no * 10 + Character.getNumericValue(ch);
                prevDigit = true;
                continue;
            }
            if (prevDigit) {
                tokens.add(new Number(no));
                no = 0;
                prevDigit = false;
            }
            if (ch == '(' || ch == ')') {
                tokens.add(new Operator(ch));
            } else {
                tokens.add(new Operator(ch));
            }
        }
        if (prevDigit) {
            tokens.add(new Number(no));
        }
        return tokens;
    }

    private int doOperation(Integer no1, Integer no2, char operator) {
        switch (operator) {
            case '+':
                return no2 + no1;
            case '-':
                return no2 - no1;
            case '*':
                return no2 * no1;
            default:
                return no2 / no1;
        }
    }

    interface Token {
    }

    static class Operator implements Comparable<Operator>, Token {
        char ch;

        Operator(char ch) {
            this.ch = ch;
        }

        boolean isParenthesis() {
            return ch == '(' || ch == ')';
        }

        @Override
        public int compareTo(Operator o) {
            return getPriority() - o.getPriority();
        }

        int getPriority() {
            switch (ch) {
                case '+':
                case '-':
                    return 1;
                default:
                    return 2;
            }
        }
    }

    static class Number implements Token {
        int no;

        Number(int n) {
            no = n;
        }
    }
}
