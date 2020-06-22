package com.algorithm.search;

public class MinMaxDivision {
    //Returns minimum  of largest block , with K  blocks

    // H - single  block , L  - N  blocks  ;  So adjust H ,L untill get K blocks
    //So  correct  block  count    ,  based on (H +L) /2  ;

    public static void main(String[] args) {
        MinMaxDivision m = new MinMaxDivision();
        int[] A = {2,4,7,8,9,12};    //  12, 17, 13
       //  int[] A = {2,1,5,1,2,2,2};   // 2,1   5,1   ,2,2,2
        int K = 3;
        int M = 12;
        System.out.println(m.solution(K,M,A));

    }


    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        int highGuess = sum(A);
        int lowGuess = max(A);
        int mid = 0;
        int smallestSum = 0;
        while (highGuess >= lowGuess) {
            mid = lowGuess  + (highGuess - lowGuess) / 2;           //  So lowGuess gives too many blocks ;  highGuess gives "too few"
            int numberOfBlock = blockCount(mid, A);
            if (numberOfBlock > K) {
                lowGuess = mid + 1;
            } else if (numberOfBlock <= K) {
                smallestSum = mid;       //Returns minimum  of largest block
                highGuess = mid - 1;
            }
        }
        return smallestSum;
    }

    public int blockCount(int max, int[] A) {
        int current = 0;
        int count = 1;
        for (int i = 0; i< A.length; i++) {
            if (current + A[i] > max) {
                current = A[i];
                count++;
            } else {
                current += A[i];
            }
        }
        return count;
    }

    public int sum(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
        }
        return total;
    }

    public int max(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) max = A[i];
        }
        return max;
    }


}