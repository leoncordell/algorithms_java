package com.algorithm.stacks;

import java.util.Stack;

public class Backets2 {
    public static void main(String[] args) {
        String S = "{[()()]}";
        System.out.println(solution(S));
    }


    static public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        if (S.charAt(0) != '(' && S.charAt(0) != '{' && S.charAt(0) != '[') {
            return 0;
        }
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (stack.isEmpty() || S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '[') {
                stack.push(S.charAt(i));
            } else if (stack.peek() == '(' && S.charAt(i) == ')') {
                stack.pop();    // {[()]}
            } else if (S.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (S.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }


}
