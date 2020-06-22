package com.algorithm.search;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] A = {5,3,1, 2, 3, 4, 5, 6};
        solution(A);
        System.out.println(Arrays.toString(A));

        int[] A2 = {1, 2, 2};
        solution(A2);
        System.out.println(Arrays.toString(A2));

        int[] A3 = {9,1, 3, 5};
        solution(A3);
        System.out.println(Arrays.toString(A3));

        int[] A4 = {7, 1, 3, 5, 7};
        solution(A4);
        System.out.println(Arrays.toString(A4));


    }



    private static void solution(int[] A) {
        // sorted on left

        boolean  sortAdj=true;
       while(sortAdj){
           sortAdj=false;
                for (int i = 0; i < A.length-1; i++) {
                    if (A[i] > A[i+1]) {
                        int tmp = A[i];
                        A[i] = A[i+1];
                        A[i+1] = tmp;
                        sortAdj=true;
                    }
                }

            }
        }

}
