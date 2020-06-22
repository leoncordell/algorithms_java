package com.algorithm.prime;

//1234  , flg 2


public class Flags {

    public static void main(String[] args) {

        int[] A7 = {6,6,6,8,6,6,6,6,5,4,4,4,4,7,6,6,6,8,6,6,6,6,5,4,4,4,4,7,3,2};       // 1st, 3rd; 5th , 11th  result   3
        System.out.println("expect 4 - " + solution(A7));


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
        // int k =0;
        //Peakss array 0,1
        boolean[] peaks = new boolean[A.length];
        int numPeaks =0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] =true;
                numPeaks++;
            }
        }
        if(numPeaks<2){
            return numPeaks;
        }
        int count = (int) Math.sqrt(A.length);
        count = Math.min(count,numPeaks);
        int[] nextPeak = new int[A.length];

        nextPeak[A.length-1] =-1;
        for (int j = A.length -2; j >= 0; j--) {
            if(peaks[j] == true){
                nextPeak[j] = j;
            }else{
                nextPeak[j] = nextPeak[j+1];
            }
        }

        int  result =0 ;
        int numFlags =0;

        while( numFlags *numFlags < A.length){
            numFlags++;            // test number
            int flagsTaken=0;
            int nextPos = 0;
            while(nextPos < A.length && flagsTaken <numFlags){
                        nextPos = nextPeak[nextPos];   // getPos
                        if(nextPos==-1){
                            break;
                        }
                        flagsTaken++;
                        nextPos =  nextPos+numFlags;          // increase index
            }
            result = Math.max(result,flagsTaken);
        }
        return result;
    }

    private boolean[] createPeaks(int[] A) {
        boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length-1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks[i] = true;
            }
        }

        return  peaks;
    }





    private int[] nextPeaks (int[] A) {
        boolean[] peaks = createPeaks(A);
        int[] nextPeaks = new int[A.length];
        // the last position is always -1
        nextPeaks[A.length-1] = -1;

        for (int i = A.length-2; i >= 0 ; i--) {
            nextPeaks[i] = peaks[i] ? i : nextPeaks[i+1];
        }

        return  nextPeaks;
    }
}

