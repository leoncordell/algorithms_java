package com.algorithm.greedy;

public class MaxNonOverlap {

    public static void main(String[] args) {
        int[] A3= {1,3,7,9,9};
        int[] B3 = {5,6,8,9,10};
        System.out.println(solution(A3,B3));

        int[] A= {1,3,5,7,8};
            int[] B = {2,4,6,8,10};

        System.out.println(solution(A,B));

        int[] A2= {1,3,5,7,9};
        int[] B2 = {2,4,6,8,10};

        System.out.println(solution(A2,B2));
    }
    static public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        // B sorted
        // greedy ?

        if(A.length < 2){
            return A.length;
        }
        int count=1;   //  Take  1st item
        int j=0; int k=1;int lastIndex=0;

        while(k<A.length){
            if(B[j] < A[k]){    // currently included j
                count++;
                j=k;            //  j index is  last included item
                k++;            //  k looks at next item after included
            }else{
                k++;
            }
        }
        // j last  included not last element
        if(A[A.length-1] > B[j] && j < A.length){
            count++;
        }

        return  count;
    }
}

