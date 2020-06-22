package com.algorithm.prime;

public class FlagsSimple {

    public static void main(String[] args) {


        int[] A7 = {6,6,6,6,7,6,6,6};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 1 - " + solution(A7));


        int[] A6 = {8,6, 5,7,2,1,7};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 1 - " + solution(A6));

        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 3 - " + solution(A));

        int[] A2 = {1, 5,6};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 0 - " + solution(A2));

        int[] A3 = {1, 5,4};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 1 - " + solution(A3));

        int[] A4 = {6, 5,4};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 0 - " + solution(A4));

        int[] A5 = {6, 5,7,1,9};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 1 - " + solution(A5));


    }

    static public int solution(int[] A) {
        // write your code in Java SE 8
        //
        if (A.length < 3) {
            return 0;
        }
        int result =0;
        boolean[] peaks = getPeaks(A);

        int flagCount =0;  // same  as  distance  between  flags
        while(flagCount*flagCount < A.length){
            int pos = 0;
            int  flagsTaken=0;
            while(pos <A.length && flagsTaken <=flagCount){
                if(peaks[pos] ==true){
                    flagsTaken++;
                    pos = pos + flagCount -1;
                }
                pos++;
            }
            result = Math.max(result,flagsTaken);
            flagCount++;
        }
        return result;
    }

    static boolean[]   getPeaks(int[] A){
        boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length -1 ; i++) {
            if(   A[i] > A[i-1]   &&  A[i] >A[i+1]){
                peaks[i]=true;
            }
        }
        return peaks;
    }

}
