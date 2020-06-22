package com.algorithm.dynamic;

import java.util.Arrays;

public class SnakesAndLadders {

    public static void main(String[] args) {
        int[] A = {3,5,9,-1,23,4,5,7,8,9,2};    //  17 +  58

        System.out.println(solution(A));
    }

    static public int solution(int[] A) {
        // write your code in Java SE 8

            int[] store = new int[A.length];
            store[0] = A[0];
            for (int i = 1; i < A.length; i++) {
                store[i] = store[i-1];
                for (int minus = 2; minus <= 6; minus++) {     ///  Considers previous 2-6 squares
                    if (i >= minus) {
                        store[i] = Math.max(store[i], store[i - minus]);  //max of previous or last 2nd- 6th prev  spaces
                    } else {
                        break;
                    }
                }
                store[i] += A[i];      //   Best  of last siz  plus current
            }
            return store[A.length - 1];
        }
    }





