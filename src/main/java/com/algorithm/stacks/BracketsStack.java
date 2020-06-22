package com.algorithm.stacks;

import java.util.Stack;

public class BracketsStack {

    public static void main(String[] args) {

        String A = "()()";

        System.out.println(solution(A));

        A = "(((((((()))))))())";
        System.out.println(solution(A));

        A = ")(";
        System.out.println(solution(A));

        // LR ok  RL  not ok   once  .....   (()(   ,

        // how  to code  against  () ()
        A = "()())";
        System.out.println(solution(A));

        A = "(((()))";
        System.out.println(solution(A));

    }


    static public int solution(String S) {
        // write your code in Java SE 8
        //
        int counter = 0;
        if (S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 != 0)
            return 0;

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) =='('){
                counter++;
            }else{
                counter--;
                if(counter<0)
                    return 0;
            }
//            if(counter<=0 && i < S.length() -1){
//                return 0;
//            }
        }
        return (counter==0)?1:0;
    }
}

//    Stack<Character> brackets = new Stack();
//        brackets.push(S.charAt(0));
//        for (int i = 1; i < S.length(); i++) {
//        if (brackets.isEmpty()) {
//            brackets.push(S.charAt(i));
//        } else if (S.charAt(i) == brackets.peek()) {     //  But   ( ( push    ( ) ) )
//            brackets.push(S.charAt(i));
//        } else {
//            brackets.pop();
//
//        }
//    }
//        return brackets.isEmpty()?1:0;
//}