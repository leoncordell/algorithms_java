package com.algorithm.greedy;

import java.util.Arrays;

public class Ropes {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(Arrays.toString(A) + " - " + solution(4, A));
        System.out.println(Arrays.toString(A) + " - " + solution(3, A));  //expect 1,2 ;3;4;3  ie  4x

    }

    static public int solution(int K, int[] A) {
        // write your code in Java SE 8
        if (K == 1) {
            return A.length;
        }

        int[] prefix = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = A[i] + prefix[i];
        }

//
        int count = 0;
        int j = prefix.length - 1;
        int k = j;
        while (j > 0) {
            if (prefix[j] - prefix[j - 1] >= K) {
                count++;

            } else if (j > 0) {
                k = j - 1;
                while (k >= 0) {
                    if (prefix[j] - prefix[k] >= K) {
                        count++;
                        j = k + 1;
                        break;
                    }
                    k--;
                }
            }
            j--;
        }
        return count;
    }


//   static  int recursive(int[] a, int start, int end,int K) {
//        if(end < start  ||  start <0) {
//            return 0;
//        }
//        if(a[end] -a[start] >=K){
//            return recursive(a, start-1 ,start,K) + 1;
//        }else{
//            return recursive(a, start -1 ,end,K) ;
//        }
//
//    }

}