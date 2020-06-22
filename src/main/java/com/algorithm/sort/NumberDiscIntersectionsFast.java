package com.algorithm.sort;

import java.util.Arrays;

public class NumberDiscIntersectionsFast {
    public static void main(String[] args) {
        int[] A = {0,1};  // 1
        System.out.println(solution(A));
        int[] A1 = {1,5,2,1,4,0};
        System.out.println(solution(A1));
    }

    static public int solution(int[] A) {
        int MAX_COUNT = 10000000;
        // write your code in Java SE 8
        if (A.length < 2) {
            return 0;
        }
        long[] start = new long[A.length];
        long[] end = new long[A.length];
        for (int i = 0; i < A.length; i++) {
            start[i] = (long)i - A[i];                     // A[3] = 2;   else 3++
            end[i] = (long)i + A[i];
                   // A[5]
        }
        Arrays.sort(start);
        Arrays.sort(end);

        long count =0;
        long openC = 0;
        int start_index=0;
        int end_index=0;
        long intersections =0;
        while(start_index <A.length){
            if(start[start_index] <= end[end_index]){  // as circle opened
                intersections = intersections + openC;
                if(intersections > MAX_COUNT){
                    return -1;
                }
                openC++;
                start_index++;
            }else{
                openC--;
                end_index++;
            }
        }

        return (int)intersections;
    }


}


//left ,right
// if  left <0 ,all intersect