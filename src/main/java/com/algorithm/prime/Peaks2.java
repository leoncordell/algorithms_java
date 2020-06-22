package com.algorithm.prime;

import java.util.Arrays;

public class Peaks2 {
    public static void main(String[] args) {

        int[] AA = {1,1,2,1,2,1,1,1,1,1,1};
        System.out.println(solution(AA));

        int[] A = {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));

        int[] A2 = {1,2,3};
        System.out.println(Arrays.toString(A2) + " = " + solution(A2));

        int[] A3 = {1,4,3};
        System.out.println(Arrays.toString(A3) + " = " + solution(A3));
        int[] A3a = {1,4,3,3};
        System.out.println(Arrays.toString(A3a) + " = " + solution(A3a));

        int[] A4 = {1,4};
        System.out.println(Arrays.toString(A4) + " = " + solution(A4));

        int[] A5 = {1};
        System.out.println(Arrays.toString(A5) + " = " + solution(A5));
    }

    static public int solution(int[] A) {
        // write your code in Java SE 8

        //Max  blocks array  divided
        //One  peak  /block  minimum
        // Block  same num elements   - ie  divisro  of N

        //1. Array true/false  of peaks
        boolean[] peaks = new boolean[A.length];
        //2. Cummulative peaks
        int[] peaksCount = new int[A.length];

        if(A.length<2)
            return 0;
        int peaksC=0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i-1] < A[i ] && A[i ] > A[i + 1]) {
                peaks[i ] = true;
                peaksC++;
                peaksCount[i ] = peaksCount[i-1] + 1;
            }else {
                peaksCount[i ] = peaksCount[i-1];
            }
        }
        peaksCount[A.length - 1] = peaksCount[A.length - 2];


        if(peaksC==1)
            return peaksC;
        //Divisors  of  N

        outer:
        for (int j = 1; j <= A.length  ; j++) {           //   size of block
            if (A.length % j == 0) {
                int prevCount = 0;
                for (int k = j-1; k < A.length; k = k + j) {      //refer  to  index
                    if (peaksCount[k] - prevCount < 1) {
                        continue outer;
                    }
                    prevCount = peaksCount[k];
                }
                return A.length / j;
            }
        }
        return 0;
    }
};
