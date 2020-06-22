package com.algorithm.search;

import java.util.Arrays;

public class NailingPlanks {
    public static void main(String[] args) {
        int[] A = {1,4,5,8};
        int[] B = {4,5,9,10};
        int[] C = {4,6,7,10,2};

        System.out.println(solution(A,B,C));


    }

    static public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8

        Arrays.sort(C);
        boolean[] Planks = new boolean[A.length];

        int count = 0;

        for(int j=0; j<C.length;j++){
            int NailPos = C[j];
//            if(applyNail(NailPos)){
//
//            }
        }
        return count;
    }




    //Sorted C , search  ,
    static boolean getNail(int[] C , int low,int high,boolean[]N){
        boolean found = false;
        //try mid C
        int  midIndex = (C.length -1)/2 ;
        while(midIndex > -1   &&  midIndex < C.length){
            if(C[midIndex] >= low && C[midIndex]<= high){
                N[midIndex] =true;
                return true;
            }
            if( low > C[midIndex] ){   // loook  for  higher  nails
                midIndex = (midIndex + C.length)/2  ;
            }
            if( high < C[midIndex] ){   // loook  for  lower  nails
                midIndex = (midIndex)/2;
            }

        }


        return  false;

    }

}
