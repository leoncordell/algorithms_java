package com.algorithm.stacks;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println(solution(s));

        s = "[{()]";
        System.out.println(solution(s));

    }

    static public int solution(String S) {
        // write your code in Java SE 8
        if(S.length() ==0){
            return 1;
        }
        if(S.length() % 2 !=0){
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for(int i =0;i<S.length();i++){
            if( S.charAt(i) == '{' || S.charAt(i) == '['  || S.charAt(i) == '(' ) {
                stack.push(S.charAt(i) );
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                Character top  = stack.peek();
                if (S.charAt(i) == '}' && top.equals('{')  || S.charAt(i) == ']' && top=='[' || S.charAt(i) ==')' && top.equals('(')){
                    stack.pop();
                }
            }


        }


        return stack.isEmpty()==true?1:0;
    }
}
